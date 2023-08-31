package odin.homework.mobilebankingv2.api.user.web;

import lombok.RequiredArgsConstructor;
import odin.homework.mobilebankingv2.api.account.Account;
import odin.homework.mobilebankingv2.api.user.UserRepository;
import odin.homework.mobilebankingv2.api.user.UserService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping
    public CollectionModel<?> findAll(){

        return userService.findAllUsers();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findByUuid(@PathVariable String uuid){

        return userService.findByUuid(uuid);
    }

    @GetMapping("/{uuid}/accounts")
    public List<Account> findAllUserAccount(@PathVariable String uuid){
        return userService.findAccountByUserUuid(uuid);
    }

    @GetMapping("/{userUuid}/accounts/{accountUuid}")
    public ResponseEntity<Account> findAccountUuidWithUserUuid(@PathVariable String userUuid, @PathVariable String accountUuid){
        Account account= userService.findAccountByUuidOfUserUuid(userUuid,accountUuid);
        return ResponseEntity.ok(account);

    }

    @PostMapping()
    public ResponseEntity<?> createNewUser(@RequestBody CreateUserDto createUserDto){

        var newUser = userService.createNewUser(createUserDto);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/{uuid}")
    public EntityModel<?> updateUserByUuid(@PathVariable String uuid, @RequestBody CreateUserDto createUserDto){

        var updatedUser = userService.updateUserByUuid(uuid,createUserDto);
        return EntityModel.of(updatedUser);
    }

    @PutMapping("/{uuid}/disable")
    public String updateStatus(@PathVariable String uuid, @RequestBody UpdateDeleteStatusDto updateDeleteStatusDto){
        return userService.updatedStatus(uuid, updateDeleteStatusDto);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> deletedByUuid(@PathVariable String uuid){
        userService.deleteUserByUuid(uuid);
        return ResponseEntity.ok("Deleted User Successfully!!");
    }

}
