package com.example.transactionService.service;

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
}
