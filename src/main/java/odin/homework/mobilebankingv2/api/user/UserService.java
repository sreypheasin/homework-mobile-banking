package odin.homework.mobilebankingv2.api.user;


import odin.homework.mobilebankingv2.api.user.web.CreateUserDto;
import odin.homework.mobilebankingv2.api.user.web.UserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface UserService {
    /**
     * Find All User
     * @return List of userDto
     */
    CollectionModel<?> findAllUsers ();

    /**
     * Find user by uuid
     * @param uuid
     * @return userDto
     */
    EntityModel<?> findByUuid(String uuid);

    /**
     * create new user
     * @param createUserDto
     * @reture UserDto
     */
    UserDto createNewUser (CreateUserDto createUserDto);

    /**
     * Deleted User by Uuid
     * @param uuid
     */
    void deleteUserByUuid(String uuid);

    /**
     * Update user by uuid
     * @param uuid
     * @param createUserDto
     * @return
     */
    UserDto updateUserByUuid (String uuid, CreateUserDto createUserDto);

}
