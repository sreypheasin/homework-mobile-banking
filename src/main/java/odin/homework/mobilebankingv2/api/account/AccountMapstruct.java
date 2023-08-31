package odin.homework.mobilebankingv2.api.account;

import odin.homework.mobilebankingv2.api.account.web.AccountDto;
import odin.homework.mobilebankingv2.api.account.web.CreateAccountDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapstruct {
//    list model to dto
    List<AccountDto> listModelToDto (List<Account> model);

//    model to Dto
    AccountDto modelToDto (Account model);

//    createAccountDtoToModel
    Account createAccountDtoToModel (CreateAccountDto model);
}
