package odin.homework.mobilebankingv2.api.account;

import lombok.AllArgsConstructor;
import odin.homework.mobilebankingv2.api.account.web.*;
import odin.homework.mobilebankingv2.api.user.User;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
        account.setTransferLimit(BigDecimal.valueOf(500));

        accountRepository.save(account);

        return accountMapstruct.modelToDto(account) ;
    }

    @Override
    public AccountDto renameAccount(String uuid ,AccountRenameDto accountRenameDto) {

        Account account =  accountRepository.findByUuid(uuid).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found")
        );

        account.setAccountName(accountRenameDto.accountName());
        Account renameAccount = accountRepository.save(account);

        return accountMapstruct.modelToDto(renameAccount);
    }

    @Override
    public String updateDeleteStatus(String uuid, UpdateDeleteStatusDto updateDeleteStatusDto) {

        Account account = accountRepository.findByUuid(uuid).orElseThrow();
        account.setIsDeleted(updateDeleteStatusDto.isDeleted());

        Account accountStatus = accountRepository.save(account);

        return ("Account status is "+ accountStatus.getIsDeleted());
    }

    @Override
    public String updateTransferLimit(String uuid, UpdateTransferLimitDto updateTransferLimitDto) {

        Account account = accountRepository.findByUuid(uuid).orElseThrow();
        account.setTransferLimit(updateTransferLimitDto.transferLimit());

        Account accountTransferLimit = accountRepository.save(account);

        return ("Transfer limit has been change to " + accountTransferLimit.getTransferLimit());
    }


}
