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
@Table(name = "sales")
@SequenceGenerator(name = "salesIdGenerator", sequenceName = "sales_id_seq", allocationSize = 1)
public class Sale {

    public Sale(Product product, double sellPrice) {
        this.product = product;
        this.sellPrice = sellPrice;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salesIdGenerator")
    private Integer id;
//    @Column(name = "product_id")
//    private Integer productId;
    @Column(name = "sell_price")
    private double sellPrice;
    @Column(name = "sell_date")
    private LocalDateTime sellDate;

    @PrePersist
    public void prePersist() {
        sellDate = LocalDateTime.now();
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "ean_code")
    private Product product;
}
