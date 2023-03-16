package com.example.test.service;


import com.example.test.dto.SalesSearchParams;
import com.example.test.entity.Sale;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SalesService {

    Sale registerSale(int productId);

    List<Sale> getSales(SalesSearchParams salesSearchParams);


}
