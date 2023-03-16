package com.example.test.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class SalesSearchParams {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate sellDateFrom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate sellDateTo;

}
