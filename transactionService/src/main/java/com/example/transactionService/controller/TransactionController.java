package com.example.transactionService.controller;

import com.example.transactionService.dto.TransactionDTO;
import com.example.transactionService.dto.TransactionRequest;
import com.example.transactionService.dto.TransactionResponse;
import com.example.transactionService.model.Transaction;
import com.example.transactionService.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    private final TransactionService transactionService;
    public TransactionController(TransactionService transactionService){
    this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionResponse> createTransaction(
            @RequestBody TransactionRequest request) {

        Transaction transaction = transactionService.createTransaction(
                request.getCustomerId(),
                request.getMerchantId(),
                request.getAmount()
        );

        TransactionResponse response = new TransactionResponse(
                transaction.getId(),
                transaction.getCustomerId(),
                transaction.getMerchantId(),
                transaction.getAmount(),
                transaction.getStatus(),
                transaction.getCreatedAt()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> getTransaction(@PathVariable Long id){
        Transaction trans = transactionService.getTransaction(id);
        TransactionResponse transDTO = new TransactionResponse(id,
                trans.getCustomerId(),
                trans.getMerchantId(),
                trans.getAmount(),
                trans.getStatus(),
                trans.getCreatedAt());
        return ResponseEntity.ok(transDTO);
    }
}
