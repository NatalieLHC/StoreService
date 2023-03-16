package com.example.test.service;


import com.example.test.dto.SalesSearchParams;
import com.example.test.entity.Sale;
import com.example.test.repository.ProductRepository;
import com.example.test.repository.SalesRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;


@Service
public class SalesServiceImpl implements SalesService {
    private final SalesRepository salesRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;

    public SalesServiceImpl(SalesRepository salesRepository, ProductRepository productRepository, ProductService productService) {
        this.salesRepository = salesRepository;
        this.productRepository = productRepository;
        this.productService = productService;
    }


    @Override
    public Sale registerSale(int productId) {
        var product = productService.getById(productId);
        var remaining = product.getRemaining();
        if(remaining == 0) {
            throw new RuntimeException("remaining equals 0");
        }
        product.setRemaining(product.getRemaining() - 1);
        var sale = new Sale(product, product.getSellPrice());
        return salesRepository.save(sale);
    }

    @Override
    public List<Sale> getSales(SalesSearchParams salesSearchParams) {
        return salesRepository.findAll((root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
             if (salesSearchParams.getSellDateFrom() !=null){
                 predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("sellDate"), salesSearchParams.getSellDateFrom().atStartOfDay()));
             }
            if (salesSearchParams.getSellDateTo() !=null){
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("sellDate"), salesSearchParams.getSellDateTo().atTime(23, 59, 59)));
            }
            return predicate;
        });
    }
}
