package com.example.digital_bank_api.dto.responses;
import java.math.BigDecimal;

public record AccountResponseDTO(
        Long id,
        String name,
        String email,
        BigDecimal balance
) {
}