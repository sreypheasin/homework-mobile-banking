package odin.homework.mobilebankingv2.api.user;

import odin.homework.mobilebankingv2.api.user.web.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUuid (String uuid);
    @Modifying
    @Query("DELETE FROM User u WHERE u.uuid = :uuid ")
    void deleteUserByUuid(@Param("uuid") String uuid);

//    @Modifying
//    @Query("UPDATE User u SET u.isDeleted = :is_deleted WHERE u.uuid = :uuid AND u.isDeleted = false")
//    Integer updateStatusByUuid (@Param("uuid") String uuid, @Param("is_deleted") Boolean isDeleted);

//   boolean existsAllByUuid(String uuid);

}
