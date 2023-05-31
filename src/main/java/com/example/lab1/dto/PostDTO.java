package com.example.lab1.dto;

import lombok.Data;

@Data
public class PostDTO {
    private long id;
    private String title;
    private String content;
    private String author;
}
