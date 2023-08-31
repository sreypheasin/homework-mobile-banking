package odin.homework.mobilebankingv2.api.accounttype;

import odin.homework.mobilebankingv2.api.accounttype.web.AccountTypeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AccountTypeRepository extends JpaRepository<AccountType,Long> {

    @Query("select new odin.homework.mobilebankingv2.api.accounttype.web.AccountTypeDto(a.name) from AccountType a")
    List<AccountTypeDto> findAllAccountTypes();

    @Query("select new odin.homework.mobilebankingv2.api.accounttype.web.AccountTypeDto(a.name) from AccountType a where a.id= :id")
    AccountTypeDto findAccountTypeById(Long id);
}
