package odin.homework.mobilebankingv2.api.account;

import lombok.AllArgsConstructor;
import odin.homework.mobilebankingv2.api.account.web.AccountDto;
import odin.homework.mobilebankingv2.api.account.web.CreateAccountDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final AccountModelAssembler accountModelAssembler;
    private final AccountMapstruct accountMapstruct;

    @Override
    public CollectionModel<?> findAccounts() {

        List<Account> accounts = accountRepository.findAll();
        return accountModelAssembler.toCollectionModel(accounts);

    }

    @Override
    public EntityModel<?> findByUuid(String uuid) {

        Account account = accountRepository.findByUuid(uuid).orElseThrow();
        return accountModelAssembler.toModel(account);

    }

    @Override
    public AccountDto createNewAccount(CreateAccountDto createAccountDto) {

        Account account = accountMapstruct.createAccountDtoToModel(createAccountDto);

        account.setUuid(UUID.randomUUID().toString());
        account.setTransferLimited(BigDecimal.valueOf(500));

        accountRepository.save(account);

        return accountMapstruct.modelToDto(account) ;
    }
}
