package com.example.test.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
@Data
public class PostSearchParams {

    private Integer postId;
    private String postTitle;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Timestamp postDate;
    private String postContent;
    private boolean deleted;
}
