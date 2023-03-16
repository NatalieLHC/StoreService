package com.example.test.controller;


import com.example.test.dto.SalesSearchParams;
import com.example.test.entity.Sale;
import com.example.test.service.SalesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("hasAuthority('MANAGER')")
@RestController
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;


    public SalesController(SalesService salesService) {
        this.salesService = salesService;

    }
    @GetMapping
    public List<Sale> findSalesByDateRange(SalesSearchParams salesSearchParams) {
        return salesService.getSales(salesSearchParams);
  }
}
