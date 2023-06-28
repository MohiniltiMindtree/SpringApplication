package com.example.ZomatoEurekaClient.Repository;

import com.example.ZomatoEurekaClient.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Payment, Integer> {
    void deleteByDid(int did);

    void findByDid(int did);
}
