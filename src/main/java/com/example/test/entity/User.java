package com.example.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@SequenceGenerator(name = "userIdGenerator", sequenceName = "users_id_seq",allocationSize = 1)
@Table(name = "users")
public class User {

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

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

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_permissions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private List<Permission> permissions;

    @PrePersist
    public void prePersist(){
        regDate=LocalDateTime.now();
        active = true;
    }
}
