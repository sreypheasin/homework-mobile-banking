package odin.homework.mobilebankingv2.api.account.web;

import lombok.AllArgsConstructor;
import odin.homework.mobilebankingv2.api.account.AccountService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public CollectionModel<?> findAll(){
        return accountService.findAccounts();
    }

    @GetMapping("/{uuid}")
    public EntityModel<?> findByUuid(@PathVariable String uuid){

        return accountService.findByUuid(uuid);
    }

//    TODO: create new account
    @PostMapping
    public ResponseEntity<?> createNewAccount(@RequestBody CreateAccountDto createAccountDto){
        var newAccount = accountService.createNewAccount(createAccountDto);
        return ResponseEntity.ok(newAccount);
    }

//    TODO: rename
    @PutMapping("/{uuid}/rename")
    public ResponseEntity<?> renameAccount(@PathVariable String uuid, @RequestBody AccountRenameDto accountRenameDto){

        var accountRename = accountService.renameAccount(uuid,accountRenameDto);
        return ResponseEntity.ok(accountRename);
    }

//    TODO: update deleted status
    @PutMapping("/{uuid}/close")
    private String updateDeleteState(@PathVariable String uuid, @RequestBody UpdateDeleteStatusDto updateDeleteStatusDto){
        var accountStatus = accountService.updateDeleteStatus(uuid,updateDeleteStatusDto);
        return accountStatus;
    }

}
