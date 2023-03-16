package com.example.test.entity;


import com.example.test.dto.ProductRegDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "categories")
@SequenceGenerator(name = "categoryIdGenerator", sequenceName = "categories_id_seq",allocationSize = 1)
public class Category {

    public Category(ProductRegDto.Category dto){
        this.id= dto.getId();
        this.categoryName= dto.getCategoryName();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryIdGenerator")
    private Integer id;
    @Column(name = "category_name")
    private String categoryName;

    @JsonManagedReference
    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
