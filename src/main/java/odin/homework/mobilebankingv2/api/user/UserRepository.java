package odin.homework.mobilebankingv2.api.user;

import odin.homework.mobilebankingv2.api.user.web.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUuid (String uuid);
    void deleteAllByUuid(String uuid);

}
