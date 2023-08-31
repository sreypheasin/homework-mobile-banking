package odin.homework.mobilebankingv2.api.authorities;

import jakarta.persistence.*;
import lombok.*;
import odin.homework.mobilebankingv2.api.role.Role;

import java.util.List;

@Entity
@Table(name = "authorities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "roles_authorities")
    List<Role> roles;
}
