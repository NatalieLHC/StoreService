package com.example.test.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "purchases")
@SequenceGenerator(name = "purchaseIdGenerator", sequenceName = "purchases_id_seq",allocationSize = 1)
public class Purchase {
    public Purchase (Product product, double productPrice) {
        this.product = product;
        this.productPrice = productPrice;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchaseIdGenerator")
    private Integer id;
//    @Column(name = "product_id")
//    private Integer productId;
    @Column(name = "product_price")
    private double productPrice;
    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @PrePersist
    public void prePersist() {
        purchaseDate = LocalDateTime.now();
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "ean_code")
    private Product product;

}
