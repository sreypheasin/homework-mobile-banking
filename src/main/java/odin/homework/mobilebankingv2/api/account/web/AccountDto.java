package odin.homework.mobilebankingv2.api.account.web;

import java.math.BigDecimal;

public record AccountDto(
    String uuid,
    String accountName,
    String accountNo,
    BigDecimal transferLimited
) {
}
