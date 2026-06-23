package com.example.digital_bank_api.dto.responses;

import com.example.digital_bank_api.enums.TransferStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransferResponseDTO(
        Long transactionId,
        Long sourceAccountId,
        Long targetAccountId,
        BigDecimal amount,
        TransferStatus status,
        LocalDateTime createdAt
) {
}
