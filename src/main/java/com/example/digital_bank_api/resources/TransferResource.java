package com.example.digital_bank_api.resources;

import com.example.digital_bank_api.dto.requests.TransferRequestDTO;
import com.example.digital_bank_api.dto.responses.TransferResponseDTO;
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

    @Operation(summary = "Transfer money between accounts")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransferResponseDTO transfer(@Valid @RequestBody TransferRequestDTO request) {
        return transferService.transfer(request);
    }

    @Operation(summary = "List transactions ordered by date")
    @GetMapping
    public List<TransferResponseDTO> findTransaction() {
        return transferService.findAllOrderByDate();
    }
}
