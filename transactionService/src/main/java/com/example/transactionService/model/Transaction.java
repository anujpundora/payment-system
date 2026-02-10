package com.example.transactionService.model;

import com.example.transactionService.enums.TransactionStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private Long merchantId;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    private LocalDateTime createdAt;

    public Transaction(){}
    public Transaction(
                       Long customerId, Long merchantId,
                       BigDecimal amount){
        this.customerId = customerId;
        this.merchantId = merchantId;
        this.amount=amount;
        this.status = TransactionStatus.PENDING;
        this.createdAt=LocalDateTime.now();
    }
    public Long getId(){
        return id;
    }
    public Long getCustomerId(){
        return customerId;
    }
    public Long getMerchantId(){
        return merchantId;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public  TransactionStatus getStatus(){
        return status;
    }
    public BigDecimal getAmount(){
        return amount;
    }
}
