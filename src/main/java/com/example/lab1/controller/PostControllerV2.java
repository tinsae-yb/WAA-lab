package com.example.lab1.controller;

import com.example.lab1.dto.PostDTO;
import com.example.lab1.dto.PostsDTO;
import com.example.lab1.exception.NotFoundException;
import com.example.lab1.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/posts", headers = {
        "x-api-version=2"
})
public class PostControllerV2 {

    private final PostService postService;

    public PostControllerV2( PostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public String getPosts() {
        return "From version two";
    }
}
