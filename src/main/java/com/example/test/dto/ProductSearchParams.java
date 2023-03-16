package com.example.test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSearchParams {

    private Integer eanCode;
    private String productName;
    private String description;
    private Integer makerId;
    private Integer categoryId;
    private double sellPrice;
    private Integer remaining;
}
