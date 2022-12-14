package com.example.test.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userIdGenerator")
    private Integer userId;
    private String username;
    private String password;
    @Column(name = "reg_date" , nullable = false)
    private LocalDateTime regDate;
    private String email;
    private boolean active;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
