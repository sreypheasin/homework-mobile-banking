package odin.homework.mobilebankingv2.api.user;

import lombok.RequiredArgsConstructor;
import odin.homework.mobilebankingv2.api.user.web.CreateUserDto;
import odin.homework.mobilebankingv2.api.user.web.UserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

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


}
