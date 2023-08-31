package odin.homework.mobilebankingv2.api.userrole;

import jakarta.persistence.*;
import lombok.*;
import odin.homework.mobilebankingv2.api.role.Role;
import odin.homework.mobilebankingv2.api.user.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "users_role")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime UpdatedAt;

    @ManyToOne
    private User user;
    @ManyToOne
    private Role role;



}
