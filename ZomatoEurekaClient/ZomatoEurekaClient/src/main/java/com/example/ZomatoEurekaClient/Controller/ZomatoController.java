package com.example.ZomatoEurekaClient.Controller;

import CommonServices.TransactionRequest;
import CommonServices.TransactionResponse;
import com.example.ZomatoEurekaClient.ExternalService.DominoesFiegnClient;
import CommonServices.Dominoes;
import com.example.ZomatoEurekaClient.Repository.TransactionRepository;
import com.example.ZomatoEurekaClient.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zomato")
@CrossOrigin
public class ZomatoController {


    @Autowired
    private DominoesFiegnClient dominoesFiegnClient;
    @Autowired
    private PaymentService service;

    @Autowired
    TransactionRepository transactionRepository;

    //Get Dominoes data in zomato by using Id
    @GetMapping(value = "/getzomato/{id}", produces = "application/json")
    public Dominoes getDominoes(@PathVariable int id) {
        return dominoesFiegnClient.getDominosById(id);
    }

    //Get Dominoes  all data in zomato
    @GetMapping(value = "/getAllzomato", produces = "application/json")
    public List<Dominoes> getAllDominoes() {
        return dominoesFiegnClient.getDominos();
    }

    //Save Data using zomato by using dominoes
    @PostMapping(value = "/savezomato", consumes = "application/json")
    public String saveDominoes(@RequestBody Dominoes dominoes) {
        return dominoesFiegnClient.saveDominos(dominoes);
    }

    //Save Payment Data and get domies data of perticular customer to perform transaction
    @PostMapping(value = "/savePayment", consumes = "application/json")
    public TransactionResponse saveDominoes(@RequestBody TransactionRequest request) {
        return service.saveTransaction(request);
    }

    @DeleteMapping(value="/deleteZomato/{did}")
    public String deleteZomato(@PathVariable int did)
    {
        dominoesFiegnClient.deleteDominosById(did);
        return "data deleted SucessFully";
    }

    @DeleteMapping(value="/deletePayment/{did}")
    public String deletePayment(@PathVariable int did)
    {
        transactionRepository.deleteByDid(did);
        return "data deleted Successfully";
    }



}


