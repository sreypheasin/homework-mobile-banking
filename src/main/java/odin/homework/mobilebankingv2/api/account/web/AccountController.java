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

    @PostMapping
    public ResponseEntity<?> createNewAccount(@RequestBody CreateAccountDto createAccountDto){
        var newAccount = accountService.createNewAccount(createAccountDto);
        return ResponseEntity.ok(newAccount);
    }
}
