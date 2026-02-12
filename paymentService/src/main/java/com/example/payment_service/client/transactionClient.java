package com.example.payment_service.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
public class transactionClient {
        private final RestTemplate restTemplate;

        @Value("${transaction.service.base-url}")
        private String transactionServiceBaseUrl;

        public transactionClient(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        // 1️⃣ Create Transaction
        public TransactionResponse createTransaction(
                Long customerId,
                Long merchantId,
                BigDecimal amount) {

            String url = transactionServiceBaseUrl + "/transactions";

            TransactionRequest request =
                    new TransactionRequest(customerId, merchantId, amount);

            return restTemplate.postForObject(
                    url,
                    request,
                    TransactionResponse.class
            );
        }

        // 2️⃣ Update Status
        public TransactionResponse updateTransactionStatus(
                Long transactionId,
                TransactionStatus status) {

            String url = transactionServiceBaseUrl +
                    "/transactions/" + transactionId + "/status";

            UpdateTransactionRequest request =
                    new UpdateTransactionRequest(status);

            HttpEntity<UpdateTransactionRequest> entity =
                    new HttpEntity<>(request);

            ResponseEntity<TransactionResponse> response =
                    restTemplate.exchange(
                            url,
                            HttpMethod.PATCH,
                            entity,
                            TransactionResponse.class
                    );

            return response.getBody();
        }

}
