package com.example.test.service;


import com.example.test.dto.ProductRegDto;
import com.example.test.dto.ProductSearchParams;
import com.example.test.entity.Category;
import com.example.test.entity.Maker;
import com.example.test.entity.Product;
import com.example.test.repository.CategoryRepository;
import com.example.test.repository.MakerRepository;
import com.example.test.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MakerRepository makerRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, MakerRepository makerRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.makerRepository = makerRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<Product> getProducts(ProductSearchParams productSearchParams) {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public Product registerProduct(ProductRegDto productRegDto) {

        var makerDto = productRegDto.getMaker();
        var maker = new Maker(makerDto);
        if (maker.getId() == null) {
            makerRepository.save(maker);
        }

        var categoryDto = productRegDto.getCategory();
        var category = new Category(categoryDto);
        if (category.getId() == null) {
            categoryRepository.save(category);
        }

        var productDto = productRegDto.getProduct();
        var product = new Product(productDto);
        product.setMaker(maker);
        product.setCategory(category);
        productRepository.save(product);
        return product;
    }

    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

}
