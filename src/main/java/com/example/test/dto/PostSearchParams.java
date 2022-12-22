package com.example.test.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
public class PostSearchParams  {
    private String postTitle;
    private String postContent;
    private String username;
    private Integer postId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate postDateFrom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate postDateTo;
}
