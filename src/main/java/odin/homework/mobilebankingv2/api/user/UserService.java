package odin.homework.mobilebankingv2.api.user;


import odin.homework.mobilebankingv2.api.account.Account;
import odin.homework.mobilebankingv2.api.user.web.CreateUserDto;
import odin.homework.mobilebankingv2.api.user.web.UpdateDeleteStatusDto;
import odin.homework.mobilebankingv2.api.user.web.UserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.List;

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
     * Find account by user uuid
     * @param uuid
     * @return
     */
    List<Account> findAccountByUserUuid(String uuid);

    /**
     * Find account by uuid using user uuid
     * @param userUuid
     * @param accountUuid
     * @return Account
     */
    Account findAccountByUuidOfUserUuid(String userUuid, String accountUuid);



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
     * @return UserDto
     */
    UserDto updateUserByUuid (String uuid, CreateUserDto createUserDto);

    /**
     * update user is_deleted status
     * @param uuid
     * @param updateDeleteStatusDto
     * @return String message
     */
    String updatedStatus (String uuid, UpdateDeleteStatusDto updateDeleteStatusDto);


}
