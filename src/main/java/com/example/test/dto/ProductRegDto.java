package com.example.test.dto;


import com.example.test.entity.Category;
import com.example.test.entity.Maker;
import com.example.test.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRegDto {

    private Product product;
    private Maker maker;
    private Category category;

    @Getter
    @Setter
    public static class Product {
        private Integer eanCode;
        private String productName;
        private String description;
        private double sellPrice;
    }

    @Getter
    @Setter
    public static class Maker {
        private Integer id;
        private String makerName;
    }
    @Getter
    @Setter
    public static class Category {
        private Integer id;
        private String categoryName;
    }
}
