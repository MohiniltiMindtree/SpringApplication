package com.example.ZomatoEurekaClient.ServiceImpl;

import CommonServices.Dominoes;
import CommonServices.TransactionRequest;
import CommonServices.TransactionResponse;
import com.example.ZomatoEurekaClient.ExternalService.DominoesFiegnClient;
import com.example.ZomatoEurekaClient.Model.Payment;
import com.example.ZomatoEurekaClient.Repository.TransactionRepository;
import com.example.ZomatoEurekaClient.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    TransactionRepository repository;
    @Autowired
    DominoesFiegnClient feignClient;

    @Override
    public TransactionResponse saveTransaction(TransactionRequest request) {
        String message="";
        Payment payment = request.getPayment();
        Dominoes dominos = feignClient.getDominosById(payment.getDid());
        repository.save(payment);
        message=payment.getTransactionStatus().equalsIgnoreCase("success")?"payment SucessFull":"Payment is not successfull";
        return new TransactionResponse(dominos,payment,message);
    }
}
