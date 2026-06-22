package com.example.digital_bank_api.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public record TransferRequest(
        @NotNull
        Long sourceAccountId,
        @NotNull
        Long targetAccountId,
        @NotNull
        BigDecimal amount
) {
}
