package odin.homework.mobilebankingv2.api.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String uuid;

    private String name;

    private String gender;

    private String email;

    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "one_signal_id")
    private String oneSignalId;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private Boolean isDeleted;

    @Column(name = "is_student")
    private Boolean isStudent;

    @Column(name = "student_card_id")
    private String studentCardId;

    @Column(name = "is_verified")
    private Boolean isVerified;

    @Column(name = "verified_code")
    private String verifiedCode;
}
