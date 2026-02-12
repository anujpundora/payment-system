package com.example.transactionService.service;

import com.example.transactionService.enums.TransactionStatus;
import com.example.transactionService.exception.TransactionNotFoundException;
import com.example.transactionService.model.Transaction;
import com.example.transactionService.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    //Create new Transaction
    public Transaction createTransaction(Long customerId,Long merchantId, BigDecimal amount){
            Transaction tr = new Transaction(customerId,merchantId,amount);
            return transactionRepository.save(tr);
    }
    //Get Transaction details
    public  Transaction getTransaction(Long id){
        return transactionRepository.findById(id).orElseThrow();
    }
    public Transaction updateTransactionStatus(Long id,TransactionStatus status){
        Transaction transaction = transactionRepository.findById(id).
                orElseThrow(()->new TransactionNotFoundException(id));
        transaction.setStatus(status);
        return transactionRepository.save(transaction);
    }
}
