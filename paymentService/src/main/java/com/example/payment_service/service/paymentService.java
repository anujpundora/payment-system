package com.example.payment_service.service;

public class paymentService {
    private final UserClient userClient;
    private final TransactionClient transactionClient;
    public paymentService(UserClient userClient,
                          TransactionClient transactionClient){
        this.userClient = userClient;
        this.transactionClient = transactionClient;
    }
    userClient.validateUser(customerId);
        userClient.validateUser(merchantId);

    TransactionResponse transaction =
            transactionClient.createTransaction(
                    customerId,
                    merchantId,
                    amount
            );

    TransactionStatus finalStatus;

        if (amount.compareTo(new BigDecimal("10000")) < 0) {
        finalStatus = TransactionStatus.SUCCESS;
    } else {
        finalStatus = TransactionStatus.FAILED;
    }

    TransactionResponse updatedTransaction =
            transactionClient.updateTransactionStatus(
                    transaction.getId(),
                    finalStatus
            );

        return new PaymentResponse(
            updatedTransaction.getId(),
                updatedTransaction.getStatus(),
                        updatedTransaction.getAmount()
                        );
}
}
