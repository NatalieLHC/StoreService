package com.example.test.repository;

import com.example.test.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SalesRepository extends JpaRepository<Sale, Integer>, JpaSpecificationExecutor<Sale> {

}
