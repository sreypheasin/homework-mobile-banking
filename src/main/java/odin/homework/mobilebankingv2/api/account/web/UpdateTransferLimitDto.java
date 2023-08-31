package odin.homework.mobilebankingv2.api.account.web;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record UpdateTransferLimitDto (BigDecimal transferLimit) {
}
