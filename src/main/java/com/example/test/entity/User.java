package com.example.test.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@SequenceGenerator(name = "userIdGenerator", sequenceName = "users_user_id_seq",allocationSize = 1)
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdGenerator")
    private Integer userId;
    private String username;
    private String password;
    @Column(name = "reg_date")
    private LocalDateTime regDate;
    private String email;
    private boolean active;

//    @OneToMany
//    private List<Post> posts;
}
