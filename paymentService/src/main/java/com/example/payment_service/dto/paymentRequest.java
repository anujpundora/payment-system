package com.example.payment_service.dto;

import java.math.BigDecimal;

public class paymentRequest {
    private Long transactionid;
    private TransactionStatus status;
    private BigDecimal amount;

    public paymentRequest(){}

    public paymentRequest(Long transactionid,TransactionStatus status,BigDecimal amount){
        this.transactionid = transactionid;
        this.status = status;
        this.amount = amount;
    }
    public Long getTransactionid(){
        return transactionid;
    }
    public TransactionStatus getStatus(){
        return status;
    }
    public  BigDecimal getAmount(){
        return  amount;
    }
}
