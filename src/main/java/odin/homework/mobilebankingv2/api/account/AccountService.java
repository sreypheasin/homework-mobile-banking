package odin.homework.mobilebankingv2.api.account;

import odin.homework.mobilebankingv2.api.account.web.AccountDto;
import odin.homework.mobilebankingv2.api.account.web.AccountRenameDto;
import odin.homework.mobilebankingv2.api.account.web.CreateAccountDto;
import odin.homework.mobilebankingv2.api.account.web.UpdateDeleteStatusDto;
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
     * @return Account Dto
     */
    AccountDto createNewAccount(CreateAccountDto createAccountDto);

    /**
     * Rename account's name
     * @param uuid
     * @param accountRenameDto
     * @return AccountDto
     */
    AccountDto renameAccount (String uuid, AccountRenameDto accountRenameDto);

    /**
     * Update deleted status
     * @param uuid
     * @param updateDeleteStatusDto
     * @return String
     */
    String updateDeleteStatus(String uuid, UpdateDeleteStatusDto updateDeleteStatusDto);

}
