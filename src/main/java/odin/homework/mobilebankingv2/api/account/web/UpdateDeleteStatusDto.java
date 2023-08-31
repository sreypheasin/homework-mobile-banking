package odin.homework.mobilebankingv2.api.account.web;

import lombok.Builder;

@Builder
public record UpdateDeleteStatusDto (Boolean isDeleted) {
}
