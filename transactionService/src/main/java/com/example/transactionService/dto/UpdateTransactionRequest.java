package com.example.transactionService.dto;

import com.example.transactionService.enums.TransactionStatus;
import com.example.transactionService.service.TransactionService;
import org.hibernate.sql.Update;

public class UpdateTransactionRequest {
    private TransactionStatus status;
    public UpdateTransactionRequest(){}
    public UpdateTransactionRequest(TransactionStatus status){
        this.status = status;
    }

    public TransactionStatus getStatus(){
        return status;
    }
}