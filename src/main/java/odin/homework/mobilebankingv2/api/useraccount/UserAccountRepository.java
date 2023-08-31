package odin.homework.mobilebankingv2.api.useraccount;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
    List<UserAccount> findByUserUuid(String uuid);
    Optional<UserAccount> findByUser_UuidAndAccount_Uuid(String userUuid, String accountUuid);
}
