package odin.homework.mobilebankingv2.api.user;


import lombok.RequiredArgsConstructor;
import odin.homework.mobilebankingv2.api.user.web.CreateUserDto;
import odin.homework.mobilebankingv2.api.user.web.UserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;
    private final UserModelAssembler userModelAssembler;
    private final UserMapstruct userMapstruct;

//    TODO: FInd
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

//    TODO: create user
    @Override
    public UserDto createNewUser(CreateUserDto createUserDto) {

        User user = userMapstruct.createUserDtoToUser(createUserDto);

        user.setUuid(UUID.randomUUID().toString());
        User newUser = userRepository.save(user);

        return userMapstruct.userToUserDto(newUser);
    }

    //    TODO: delete user
    @Transactional
    @Override
    public void deleteUserByUuid(String uuid) {
        userRepository.deleteUserByUuid(uuid);
    }

//    TODO: update user by uuid
    @Override
    public UserDto updateUserByUuid(String uuid, CreateUserDto createUserDto) {
//        I use createUser Dto as updateUserDto

        User update = userRepository.findByUuid(uuid).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User with uuid %s not found",uuid))
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
}
