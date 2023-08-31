package odin.homework.mobilebankingv2.api.accounttype.web;

import lombok.RequiredArgsConstructor;
import odin.homework.mobilebankingv2.api.accounttype.AccountType;
import odin.homework.mobilebankingv2.api.accounttype.AccountTypeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account_types")
public class AccountTypeController {
    private final AccountTypeRepository accountTypeRepository;

    @GetMapping
    public List<AccountTypeDto> findAll(){
        List<AccountTypeDto> accountTypes = accountTypeRepository.findAllAccountTypes();
        return  accountTypes;
    }

    @GetMapping("/{id}")
    public AccountTypeDto findById(@PathVariable Long id){
        AccountTypeDto accountTypeDto = accountTypeRepository.findAccountTypeById(id);
        return accountTypeDto;
    }
}
