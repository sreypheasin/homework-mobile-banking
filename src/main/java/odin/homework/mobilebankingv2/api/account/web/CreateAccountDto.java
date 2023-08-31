package odin.homework.mobilebankingv2.api.account.web;

import lombok.Builder;

@Builder
public record CreateAccountDto(
        String accountName,
        String accountNo,
        String pin) {
}
