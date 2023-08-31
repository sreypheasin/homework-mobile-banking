package odin.homework.mobilebankingv2.api.role;


import jakarta.persistence.*;
import lombok.*;
import odin.homework.mobilebankingv2.api.authorities.Authorities;

import java.util.List;

@Entity
@Table(name = "roles")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roles")
    List<Authorities> authorities;
}
