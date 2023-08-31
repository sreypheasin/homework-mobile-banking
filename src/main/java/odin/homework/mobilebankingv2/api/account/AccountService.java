package odin.homework.mobilebankingv2.api.account;

import odin.homework.mobilebankingv2.api.account.web.AccountDto;
import odin.homework.mobilebankingv2.api.account.web.CreateAccountDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

public interface AccountService {
    /**
     * Find all accounts
     * @return List of AccountDto
     */
    CollectionModel<?> findAccounts();

    /**
     * Find account by uuid
     * @param uuid
     * @return
     */
    EntityModel<?> findByUuid(String uuid);

    /**
     * create new account
     * @param createAccountDto
     * @return
     */
    AccountDto createNewAccount(CreateAccountDto createAccountDto);
}
