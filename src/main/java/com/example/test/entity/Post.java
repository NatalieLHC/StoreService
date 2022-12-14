package com.example.test.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@SequenceGenerator(name = "postsIdGenerator", sequenceName = "posts_post_id_seq",allocationSize = 1)
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postsIdGenerator")
    @Column(name = "id", nullable = false)
    private Integer postId;
    @Column(name = "title", nullable = false)
    private String postTitle;
    @Column(name = "create_date", nullable = false)
    private LocalDateTime postDate;
    @Column(name = "content", nullable = false)
    private String postContent;
    private boolean deleted;
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false, insertable = false)
    private User user;


//test

}
