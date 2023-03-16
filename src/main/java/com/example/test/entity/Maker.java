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
@Table(name = "maker")
@SequenceGenerator(name = "makerIdGenerator", sequenceName = "makers_id_seq",allocationSize = 1)
public class Maker {

    public Maker(ProductRegDto.Maker dto){
        this.id = dto.getId();
        this.makerName = dto.getMakerName();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "makerIdGenerator")
    private Integer id;
    @Column(name = "maker_name", nullable = false)
    private String makerName;

    @JsonManagedReference
    @OneToMany(mappedBy = "maker")
    private List<Product> products;
}
