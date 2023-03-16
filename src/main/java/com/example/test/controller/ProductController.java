package com.example.test.controller;

import com.example.test.dto.ProductRegDto;
import com.example.test.dto.ProductSearchParams;
import com.example.test.entity.Product;
import com.example.test.entity.Purchase;
import com.example.test.entity.Sale;
import com.example.test.repository.ProductRepository;
import com.example.test.repository.SalesRepository;
import com.example.test.service.ProductService;
import com.example.test.service.PurchaseService;
import com.example.test.service.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@PreAuthorize("hasAuthority('CASHIER')")
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final SalesService salesService;
    private final PurchaseService purchaseService;
    private final ProductRepository productRepository;


    public ProductController(ProductService productService, SalesRepository salesRepository, SalesService salesService, PurchaseService purchaseService,
                             ProductRepository productRepository) {
        this.productService = productService;
        this.salesService = salesService;
        this.purchaseService = purchaseService;
        this.productRepository = productRepository;
    }

    @GetMapping

    public List<Product>getProducts(ProductSearchParams productSearchParams){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @PostMapping("/register")

    public ResponseEntity<Product> registerProduct(@RequestBody ProductRegDto productRegDto) {
        if (productRegDto.getProduct() == null || productRegDto.getCategory() == null || productRegDto.getMaker() == null) {
            return ResponseEntity.badRequest().build();
        }
        Product registered = productService.registerProduct(productRegDto);
        var location = UriComponentsBuilder.fromPath("/products/{id}").buildAndExpand(registered.getEanCode()).toUri();
        return ResponseEntity.created(location).body(registered);
    }
    @PreAuthorize("hasAuthority('MANAGER')")
    @PostMapping("/{id}/sales")
    public Sale addSale(@PathVariable int id) {
        return salesService.registerSale(id);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @PostMapping("/{id}/purchases")
    public Purchase addPurchase(@PathVariable int id) {
        return purchaseService.registerPurchase(id);
    }
}
