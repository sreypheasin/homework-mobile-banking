package odin.homework.mobilebankingv2.api.user.web;

import lombok.Builder;

@Builder
public record UpdateDeleteStatusDto(Boolean isDeleted) {
}
