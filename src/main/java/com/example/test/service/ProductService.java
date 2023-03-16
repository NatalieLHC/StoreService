package com.example.test.service;


import com.example.test.dto.ProductRegDto;
import com.example.test.dto.ProductSearchParams;
import com.example.test.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product registerProduct(ProductRegDto productRegDto);

    List<Product> getProducts(ProductSearchParams productSearchParams);

    Product getById(int id);


}
