package odin.homework.mobilebankingv2.api.user;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import odin.homework.mobilebankingv2.api.account.Account;
import odin.homework.mobilebankingv2.api.user.web.CreateUserDto;
import odin.homework.mobilebankingv2.api.user.web.UpdateDeleteStatusDto;
import odin.homework.mobilebankingv2.api.user.web.UserDto;
import odin.homework.mobilebankingv2.api.useraccount.UserAccount;
import odin.homework.mobilebankingv2.api.useraccount.UserAccountRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private final UserModelAssembler userModelAssembler;
    private final UserMapstruct userMapstruct;
    private final UserAccountRepository userAccountRepository;


    //    TODO: Find
    @Override
    public CollectionModel<?> findAllUsers() {

        List<User> users = userRepository.findAll();
        return userModelAssembler.toCollectionModel(users);

    }
    @Override
    public EntityModel<?> findByUuid(String uuid) {

        User user = userRepository.findByUuid(uuid).orElseThrow();
        return userModelAssembler.toModel(user);

    }

    @Override
    public List<Account> findAccountByUserUuid(String uuid) {
        List<UserAccount> userAccounts = userAccountRepository.findByUserUuid(uuid);
        List<Account> accounts = userAccounts.stream()
                .map(UserAccount::getAccount)
                .collect(Collectors.toList());

        return accounts;
    }

    @Override
    public Account findAccountByUuidOfUserUuid(String userUuid, String accountUuid) {

        User user = userRepository.findByUuid(userUuid)
                .orElseThrow(() -> new EntityNotFoundException("User not found for the given UUID"));

        return userAccountRepository.findByUser_UuidAndAccount_Uuid(userUuid, accountUuid)
                .map(UserAccount::getAccount)
                .orElseThrow(() -> new EntityNotFoundException("Account not found for the given user and account UUIDs."));
    }

    @Override
    public UserDto createNewUser(CreateUserDto createUserDto) {

        User user = userMapstruct.createUserDtoToUser(createUserDto);

        user.setUuid(UUID.randomUUID().toString());
        User newUser = userRepository.save(user);

        return userMapstruct.userToUserDto(newUser);
    }

    @Override
    public UserDto updateUserByUuid(String uuid, CreateUserDto createUserDto) {

        //        I use createUser Dto as updateUserDto
        User update = userRepository.findByUuid(uuid).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User with uuid %s not found",uuid))
        );

        update.setName(createUserDto.name());
        update.setGender(createUserDto.gender());
        update.setPassword(createUserDto.password());
        update.setEmail(createUserDto.email());
        update.setPhoneNumber(createUserDto.phoneNumber());
        update.setIsStudent(createUserDto.isStudent());

        User user = userRepository.save(update);
        return userMapstruct.userToUserDto(user);
    }

    @Override
    public String updatedStatus(String uuid, UpdateDeleteStatusDto updateDeleteStatusDto) {

        User user = userRepository.findByUuid(uuid).orElseThrow();

        user.setIsDeleted(updateDeleteStatusDto.isDeleted());

        User userStatus = userRepository.save(user);
        return ("User status is "+ userStatus.getIsDeleted());
    }

    @Transactional
    @Override
    public void deleteUserByUuid(String uuid) {

        userRepository.deleteUserByUuid(uuid);
    }

}
