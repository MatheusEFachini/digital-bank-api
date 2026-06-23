package com.example.digital_bank_api.service;

import com.example.digital_bank_api.dto.responses.AccountResponseDTO;
import com.example.digital_bank_api.entities.Account;
import com.example.digital_bank_api.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public List<AccountResponseDTO> findAllAccounts() {
        return accountRepository
                .findAll()
                .stream()
                .map(this::toAccountResponse)
                .toList();
    }

    private AccountResponseDTO toAccountResponse(Account account) {
        return new AccountResponseDTO(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getBalance()
        );
    }
}
