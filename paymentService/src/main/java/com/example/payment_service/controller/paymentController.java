package com.example.payment_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payments")
public class paymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> processPayment(
            @RequestBody PaymentRequest request) {

        PaymentResponse response =
                paymentService.processPayment(
                        request.getCustomerId(),
                        request.getMerchantId(),
                        request.getAmount()
                );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }
}
