package odin.homework.mobilebankingv2.api.account;

import jakarta.persistence.*;
import lombok.*;
import odin.homework.mobilebankingv2.api.accounttype.AccountType;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String uuid;

    @Column(name = "transfer_limit")
    private BigDecimal transferLimited;

    @Column(name = "act_name")
    private String accountName;

    @Column(name = "act_no")
    private String accountNo;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    private String pin;

    @ManyToOne
    private AccountType accountTypes;
}
