package com.example.digital_bank_api.resources;

import com.example.digital_bank_api.dto.responses.AccountResponseDTO;
import com.example.digital_bank_api.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Accounts")
@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountResource {

    private AccountService accountService;

    @Operation(summary = "List all accounts")
    @GetMapping
    public List<AccountResponseDTO> findAllAccounts() {
        return accountService.findAllAccounts();
    }
}
