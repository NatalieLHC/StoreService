package com.example.test.entity;

import com.example.test.dto.ProductRegDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@SequenceGenerator(name = "productIdGenerator", sequenceName = "products_ean_code_seq",allocationSize = 1)

public class Product {

    public  Product(ProductRegDto.Product dto){
        this.eanCode= dto.getEanCode();
        this.productName= dto.getProductName();
        this.description=dto.getDescription();
        this.sellPrice= dto.getSellPrice();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productIdGenerator")
    @Column(name = "ean_code", nullable = false)
    private Integer eanCode;
    @Column(name = "product_name", nullable = false)
    private String productName;
    private String description;
    @Column(name = "maker_id", nullable = false, insertable = false,updatable = false)
    private Integer makerId;
    @Column(name = "category_id", nullable = false, insertable = false,updatable = false)
    private Integer categoryId;
    @Column(name = "sell_price", nullable = false)
    private double sellPrice;

    @Column(name = "remaining", nullable = false, columnDefinition = "integer default 1")
    private Integer remaining;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "maker_id", referencedColumnName = "id")
    private Maker maker;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<Sale> sales;

    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<Sale> purchases;

    @PrePersist
    public void prePersist() {
        remaining = 1;
    }
}
