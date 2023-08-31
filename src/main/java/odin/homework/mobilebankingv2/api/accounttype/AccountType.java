package odin.homework.mobilebankingv2.api.accounttype;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
