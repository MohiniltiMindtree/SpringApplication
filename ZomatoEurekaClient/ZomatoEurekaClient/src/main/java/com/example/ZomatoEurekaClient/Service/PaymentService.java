package com.example.ZomatoEurekaClient.Service;

import CommonServices.TransactionRequest;
import CommonServices.TransactionResponse;
import org.springframework.stereotype.Service;


public interface PaymentService {
    TransactionResponse saveTransaction(TransactionRequest request);
}
