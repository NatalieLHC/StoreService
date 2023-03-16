package com.example.test.service;

import com.example.test.entity.Purchase;
import com.example.test.entity.Sale;
import com.example.test.repository.ProductRepository;
import com.example.test.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    private final PurchaseRepository purchaseRepository;
    private final ProductService productService;
    private final ProductRepository productRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, ProductService productService, ProductRepository productRepository) {
        this.purchaseRepository = purchaseRepository;
        this.productService = productService;
        this.productRepository = productRepository;
    }


    @Override
    public Purchase registerPurchase(int productId) {
        var product = productService.getById(productId);
        var remaining = product.getRemaining();
        product.setRemaining(product.getRemaining() + 1);
        var purchase = new Purchase(product, product.getSellPrice());
        return purchaseRepository.save(purchase);
    }


    }

