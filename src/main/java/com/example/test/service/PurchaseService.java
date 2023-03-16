package com.example.test.service;

import com.example.test.entity.Purchase;
import org.springframework.stereotype.Service;

@Service
public interface PurchaseService {

    Purchase registerPurchase(int productId);
}
