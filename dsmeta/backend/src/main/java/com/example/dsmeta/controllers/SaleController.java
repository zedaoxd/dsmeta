package com.example.dsmeta.controllers;

import com.example.dsmeta.entities.Sale;
import com.example.dsmeta.services.SaleService;
import com.example.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @Autowired
    private SmsService smsService;

    @GetMapping
    public ResponseEntity<Page<Sale>> getAllPage(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "")String maxDate,
            Pageable pageable) {
        return ResponseEntity.ok().body(service.listAllPages(minDate, maxDate, pageable));
    }

    @GetMapping("/{id}/notification")
    public ResponseEntity<Void> notifySms(@PathVariable("id") Long id) {
        smsService.sendSms(id);
        return ResponseEntity.ok().build();
    }
}
