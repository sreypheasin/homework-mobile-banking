package odin.homework.mobilebankingv2.util;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import odin.homework.mobilebankingv2.api.account.Account;
import odin.homework.mobilebankingv2.api.account.AccountRepository;
import odin.homework.mobilebankingv2.api.accounttype.AccountType;
import odin.homework.mobilebankingv2.api.accounttype.AccountTypeRepository;
import odin.homework.mobilebankingv2.api.user.User;
import odin.homework.mobilebankingv2.api.user.UserRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataSources {
    private final AccountTypeRepository accountTypeRepository;
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @PostConstruct
    void init(){
        AccountType accountType1 = AccountType.builder()
                .name("saving")
                .build();
        AccountType accountType2 = AccountType.builder()
                .name("credit card")
                .build();
        AccountType accountType3 = AccountType.builder()
                .name("payment")
                .build();

        User user1 = User.builder()
                .uuid(UUID.randomUUID().toString())
                .name("Odin")
                .gender("f")
                .isDeleted(false)
                .email("odinn@gmail.com")
                .phoneNumber("015 799 159")
                .build();
        User user2 = User.builder()
                .uuid(UUID.randomUUID().toString())
                .name("Sen")
                .gender("m")
                .email("senpai@gmail.com")
                .phoneNumber("078 808 938")
                .isDeleted(false)
                .build();


        Account account1 = Account.builder()
                .uuid(UUID.randomUUID().toString())
                .accountName("Sin Sreyphea")
                .accountNo("ab1234")
                .transferLimited(BigDecimal.valueOf(1000))
                .isDeleted(false)
                .pin("abcd12")
                .build();

        accountTypeRepository.saveAll(List.of(accountType1,accountType2,accountType3));
        userRepository.saveAll(List.of(user1,user2));
        accountRepository.saveAll(List.of(account1));

    }
}
