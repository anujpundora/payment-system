package com.example.transactionService.model;

import com.example.transactionService.enums.TransactionStatus;
import jakarta.annotation.Generated;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    long custumerId;
    long merchantId;
    double amount;
    @Enumerated(EnumType.STRING)
    TransactionStatus status;
    Time createdAt;
    public Transaction(){}
    public Transaction(
                       long custumerId, long merchantId, double amount,Time createdAt){
        this.custumerId = custumerId;
        this.merchantId = merchantId;
        this.amount=amount;
        this.createdAt = createdAt;
    }
    public long getId(){
        return id;
    }
    public long getCostumerId(){
        return custumerId;
    }
    public long getMerchantId(){
        return merchantId;
    }
    public Time getCreatedAt(){
        return createdAt;
    }
    public  TransactionStatus getStatus(){
        return status;
    }
}
