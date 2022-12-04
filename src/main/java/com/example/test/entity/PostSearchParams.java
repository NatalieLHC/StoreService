package com.example.test.entity;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class PostSearchParams {

    private Integer postId;
    private String postTitle;
    private Timestamp postDate;
    private String postContent;
    private boolean deleted;
}
