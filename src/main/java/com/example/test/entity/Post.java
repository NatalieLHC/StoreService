package com.example.test.entity;

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
    @Column(name = "post_id")
    private Integer postId;
    @Column(name = "post_title")
    private String postTitle;
    @Column(name = "post_date")
    private LocalDateTime postDate;
    @Column(name = "post_content")
    private String postContent;
    private boolean deleted;
    @Column(name = "user_id")
    private Integer userId;

}
