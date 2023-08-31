package odin.homework.mobilebankingv2.api.account.web;

import lombok.Builder;

@Builder
public record AccountRenameDto(String accountName) {
}
