package odin.homework.mobilebankingv2.api.transaction;

import jakarta.persistence.*;
import lombok.*;
import odin.homework.mobilebankingv2.api.account.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    @Column(name = "student_card_id")
    private String studentCardId;
    private String remark;
    @Column(name = "transfer_at")
    private LocalDateTime transferAt;
    private BigDecimal amount;
    @Column(name = "is_payment")
    private Boolean isPayment;
    @ManyToOne
    @JoinColumn(name = "receiver_act_id")
    private Account receiverActId;
    @ManyToOne
    @JoinColumn(name= "sender_act_id")
    private Account senderActId;


}
