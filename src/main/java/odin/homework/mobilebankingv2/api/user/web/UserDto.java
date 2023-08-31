package odin.homework.mobilebankingv2.api.user.web;

import lombok.Builder;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "users", itemRelation = "user")
@Builder
public record UserDto(
        String uuid,
        String name,
        String gender,
        String email,
        String phoneNumber,
        Boolean isDeleted
) {
}
