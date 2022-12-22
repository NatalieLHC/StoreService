package com.example.test.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
public class UserSearchParams {


    private Integer userId;
    private String username;
    private String password;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Timestamp regDate;
    private String email;
    private boolean active;
}
