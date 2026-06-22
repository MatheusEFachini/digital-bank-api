package dto;

import jakarta.annotation.Nonnull;

import java.math.BigDecimal;


public record TransferRequest(
        @Nonnull
        Long sourceAccountId,
        @Nonnull
        Long targetAccountId,
        @Nonnull
        BigDecimal amount
) {
}
