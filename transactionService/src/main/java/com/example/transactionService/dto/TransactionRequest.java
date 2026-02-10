package com.example.transactionService.dto;

import com.example.transactionService.model.Transaction;

import java.math.BigDecimal;

public class TransactionRequest {
    public TransactionRequest() {}
    private Long customerId;
    private Long merchantId;
    private BigDecimal amount;
    public TransactionRequest(Long customerId, Long merchantId, BigDecimal amount){
        this.customerId = customerId;
        this.merchantId = merchantId;
        this.amount = amount;
    }
    public Long getCustomerId(){
        return customerId;
    }
    public Long getMerchantId(){
        return merchantId;
    }
    public BigDecimal getAmount(){
        return amount;
    }
}
