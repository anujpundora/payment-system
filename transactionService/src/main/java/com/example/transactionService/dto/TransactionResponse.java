package com.example.transactionService.dto;

import com.example.transactionService.enums.TransactionStatus;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {
    private Long id;
    private Long customerId;
    private Long merchantId;
    private BigDecimal amount;
    private TransactionStatus status;
    private LocalDateTime createdAt;
    public TransactionResponse(Long id, Long customerId, Long merchantId, BigDecimal amount , TransactionStatus status , LocalDateTime time){
        this.id = id;
        this.customerId = customerId;
        this.merchantId =merchantId;
        this.amount = amount;
        this.status= status;
        this.createdAt=createdAt;
    }
    public Long getId(){
        return id;
    }
    public Long getCustomerId(){
        return customerId;
    }
    public  Long getMerchantId(){
        return merchantId;
    }
}
