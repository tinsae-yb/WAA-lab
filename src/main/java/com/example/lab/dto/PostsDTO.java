package com.example.lab1.dto;

import lombok.Data;

import java.util.List;


@Data
public class PostsDTO {
    private List<PostDTO> posts;
}
