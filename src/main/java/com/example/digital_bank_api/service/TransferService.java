package com.example.digital_bank_api.service;

import com.example.digital_bank_api.dto.TransferRequest;
import com.example.digital_bank_api.dto.TransferResponse;
import com.example.digital_bank_api.entities.Account;
import com.example.digital_bank_api.entities.Transfer;
import com.example.digital_bank_api.enums.TransferStatus;
import com.example.digital_bank_api.repositories.AccountRepository;
import com.example.digital_bank_api.repositories.TransferRepository;
import jakarta.persistence.EntityNotFoundException;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferService {

    AccountRepository accountRepository;
    TransferRepository transferRepository;

    @Transactional
    public TransferResponse transfer(TransferRequest request) {
        if (request.sourceAccountId().equals(request.targetAccountId())) {
            throw new IllegalArgumentException("You cannot transfer to same account.");
        }

        Account sourceAccount = accountRepository.findById(request.sourceAccountId())
                .orElseThrow(() -> new EntityNotFoundException("Source account not found"));

        Account targetAccount = accountRepository.findById(request.sourceAccountId())
                .orElseThrow(() -> new EntityNotFoundException("Target account not found"));

        if (sourceAccount.getBalance().compareTo(request.amount()) < 0) {
            throw new IllegalArgumentException("Insufficient balance.");
        }

        // updating value in the database first, then logging the transfer
        // all in a transactional method, in case of failure... we get a full rollback
        //TODO: add try-catch for failure logic, saving transaction with status FAILURE
        accountRepository.debitAccount(sourceAccount.getId(),request.amount());
        accountRepository.creditAccount(targetAccount.getId(),request.amount());

        Transfer savedTransaction = createSavedTransaction(request, sourceAccount, targetAccount);

        //TODO: send Notification to sourceAccount and targetAccount

        return new TransferResponse(
                savedTransaction.getId(),
                savedTransaction.getSourceAccountId(),
                savedTransaction.getTargetAccountId(),
                savedTransaction.getAmount(),
                savedTransaction.getStatus(),
                savedTransaction.getCreateDt()
        );
    }

    public List<TransferResponse> findAllOrderByDate() {
        return transferRepository
                .findAllOrderByCreateDtAsc()
                .stream()
                .map(this::toTransferResponse)
                .toList();
    }

    private TransferResponse toTransferResponse(Transfer transfer) {
        return new TransferResponse(
                transfer.getId(),
                transfer.getSourceAccountId(),
                transfer.getTargetAccountId(),
                transfer.getAmount(),
                transfer.getStatus(),
                transfer.getCreateDt()
        );
    }

    private @NonNull Transfer createSavedTransaction(TransferRequest request, Account sourceAccount, Account targetAccount) {
        Transfer transfer = Transfer.builder()
                .sourceAccountId(sourceAccount.getId())
                .targetAccountId(targetAccount.getId())
                .amount(request.amount())
                .status(TransferStatus.COMPLETE)
                .createDt(LocalDateTime.now())
                .build();
        return transferRepository.save(transfer);
    }

    private static void updateAccountBalance(Account sourceAccount, BigDecimal newBalance) {
        sourceAccount.setBalance(newBalance);
    }
}
