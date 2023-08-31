package odin.homework.mobilebankingv2.api.user.web;

import lombok.RequiredArgsConstructor;
import odin.homework.mobilebankingv2.api.user.UserRepository;
import odin.homework.mobilebankingv2.api.user.UserService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

//    TODO: Find

    @GetMapping
    public CollectionModel<?> findAll(){

        return userService.findAllUsers();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findByUuid(@PathVariable String uuid){

        return userService.findByUuid(uuid);
    }

//    TODO: Create new user
    @PostMapping()
    public ResponseEntity<?> createNewUser(@RequestBody CreateUserDto createUserDto){

        var newUser = userService.createNewUser(createUserDto);
        return ResponseEntity.ok(newUser);
    }

//    TODO: Delete user by uuid
    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> deletedByUuid(@PathVariable String uuid){
        userService.deleteUserByUuid(uuid);
        return ResponseEntity.ok("Deleted User Successfully!!");
    }

//    TODO: Updated user
    @PutMapping("/{uuid}")
    public EntityModel<?> updateUserByUuid(@PathVariable String uuid, @RequestBody CreateUserDto createUserDto){

        var updatedUser = userService.updateUserByUuid(uuid,createUserDto);
        return EntityModel.of(updatedUser);
    }

//    TODO: Updated user status
    @PutMapping("/{uuid}/disable")
    public String updateStatus(@PathVariable String uuid, @RequestBody UpdateDeleteStatusDto updateDeleteStatusDto){
        return userService.updatedStatus(uuid, updateDeleteStatusDto);
    }




}
