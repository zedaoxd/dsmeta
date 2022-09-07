package com.example.dsmeta.repositories;

import com.example.dsmeta.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    Page<Sale> findSalesByDateBetweenOrderByAmountDesc(LocalDate min, LocalDate max, Pageable pageable);
}
