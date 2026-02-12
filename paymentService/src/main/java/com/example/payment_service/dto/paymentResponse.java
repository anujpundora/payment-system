package com.example.payment_service.dto;

import java.math.BigDecimal;

public class paymentRespone{
private Long transactionId;
private TransactionStatus status;
private BigDecimal amount;

public paymentResponse(Long transactionId,
                       TransactionStatus status,
                       BigDecimal amount) {
    this.transactionId = transactionId;
    this.status = status;
    this.amount = amount;
}

public Long getTransactionId() {
    return transactionId;
}

public TransactionStatus getStatus() {
    return status;
}

public BigDecimal getAmount() {
    return amount;
}
}
}