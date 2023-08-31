package odin.homework.mobilebankingv2.api.useraccount;

import jakarta.persistence.*;
import lombok.*;
import odin.homework.mobilebankingv2.api.account.Account;
import odin.homework.mobilebankingv2.api.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isDisable;

    @ManyToOne
    private Account account;

    @ManyToOne
    private User user;


}
