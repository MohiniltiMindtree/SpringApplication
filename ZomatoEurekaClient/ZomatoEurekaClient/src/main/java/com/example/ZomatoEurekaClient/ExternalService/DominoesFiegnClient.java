package com.example.ZomatoEurekaClient.ExternalService;

import CommonServices.Dominoes;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name="Dominos")
@LoadBalancerClients
public interface DominoesFiegnClient {
    @GetMapping(value = "dominos/getDominos/{id}",produces = "application/json")
    Dominoes getDominosById(@PathVariable("id") int id);

    @GetMapping(value = "dominos/getAllDominos",produces = "application/json")
    List<Dominoes> getDominos();

    @PostMapping(value="dominos/saveDominos", produces = "application/json")
        String saveDominos(@RequestBody Dominoes dominoes);

    @DeleteMapping(value="dominos/deleteDominos/{id}")
    void deleteDominosById(@PathVariable("id") int id);


}
