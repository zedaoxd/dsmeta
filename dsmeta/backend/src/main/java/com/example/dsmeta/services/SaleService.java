package com.example.dsmeta.services;

import com.example.dsmeta.entities.Sale;
import com.example.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public Page<Sale> listAllPages(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Sale getById(Long id) {
        return repository.findById(id).get();
    }
}
