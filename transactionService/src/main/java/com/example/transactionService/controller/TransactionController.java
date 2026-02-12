package com.example.transactionService.controller;

import com.example.transactionService.dto.TransactionRequest;
import com.example.transactionService.dto.TransactionResponse;
import com.example.transactionService.dto.UpdateTransactionRequest;
import com.example.transactionService.enums.TransactionStatus;
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
    //Update Status
    @PatchMapping("/{id}/status")
    public ResponseEntity<TransactionResponse>updateStatus(@PathVariable Long id,
                                                                @RequestBody UpdateTransactionRequest request){
        Transaction updatedTransaction =
                transactionService.updateTransactionStatus(id,request.getStatus());
            TransactionResponse response = new TransactionResponse(
                    updatedTransaction.getId(),
                    updatedTransaction.getCustomerId(),
                    updatedTransaction.getMerchantId(),
                    updatedTransaction.getAmount(),
                    updatedTransaction.getStatus(),
                    updatedTransaction.getCreatedAt()
            );
            return ResponseEntity.ok(response);
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
