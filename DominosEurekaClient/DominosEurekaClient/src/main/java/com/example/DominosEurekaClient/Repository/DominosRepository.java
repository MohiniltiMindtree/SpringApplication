package com.example.DominosEurekaClient.Repository;

import com.example.DominosEurekaClient.Model.Dominoes;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

@Repository
public interface DominosRepository extends JpaRepository<Dominoes, Integer> {

    Page<Dominoes> findByNameContainingIgnoreCaseOrderByNameAsc(String name, Pageable pageable);
}
