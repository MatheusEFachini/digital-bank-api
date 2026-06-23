package com.example.digital_bank_api.dto.requests;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public record TransferRequestDTO(
        @NotNull
        Long sourceAccountId,
        @NotNull
        Long targetAccountId,
        @NotNull
        BigDecimal amount
) {
}
