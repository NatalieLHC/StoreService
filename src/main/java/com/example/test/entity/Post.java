package com.example.test.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@SequenceGenerator(name = "postsIdGenerator", sequenceName = "posts_id_seq",allocationSize = 1)
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postsIdGenerator")
    @Column(name = "id", nullable = false)
    private Integer postId;
    @Column(name = "title", nullable = false)
    private String postTitle;
    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime postDate;
    @Column(name = "content", nullable = false)
    private String postContent;
    private boolean deleted;
    @Column(name = "user_id", nullable = false,  updatable = false, insertable = false)
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @PrePersist
    public void prePersist(){
        postDate = LocalDateTime.now();
    }
}
