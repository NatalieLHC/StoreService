package com.example.test.repository;

import com.example.test.entity.Product;
import com.example.test.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}
