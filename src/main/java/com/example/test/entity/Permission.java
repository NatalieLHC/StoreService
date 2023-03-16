package com.example.test.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "permissions")
@SequenceGenerator(name = "idGenerator", sequenceName = "user_permissions_id_seq", allocationSize = 1)
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idGenerator")
    private Integer id;

    private  String name;

    @ManyToMany(mappedBy = "permissions")
    private List<User> users;
}
