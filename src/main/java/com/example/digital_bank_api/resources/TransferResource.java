package com.example.digital_bank_api.resources;

import com.example.digital_bank_api.dto.TransferRequest;
import com.example.digital_bank_api.dto.TransferResponse;
import com.example.digital_bank_api.repositories.TransferRepository;
import com.example.digital_bank_api.service.TransferService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Transfer")
@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransferResource {

    private final TransferService transferService;
    private final TransferRepository transferRepository;

    @Operation(summary = "Transfer money between accounts")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransferResponse transfer(@Valid @RequestBody TransferRequest request) {
        return transferService.transfer(request);
    }

    @Operation(summary = "List transactions ordered by date")
    @GetMapping
    public List<TransferResponse> findTransaction() {
        return transferService.findAllOrderByDate();
    }
}
