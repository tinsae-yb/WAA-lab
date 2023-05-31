package com.example.lab1.controller;

import com.example.lab1.dto.PostDTO;
import com.example.lab1.dto.PostsDTO;
import com.example.lab1.exception.NotFoundException;
import com.example.lab1.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public PostsDTO getPosts() {

        return postService.getAllPosts();

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable long id) throws NotFoundException {
        return postService.getPostById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public PostDTO createPost(@RequestBody PostDTO postDTO) {
        return postService.createPost(postDTO);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable long id) {
        postService.deletePost(id);
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    public PostDTO updatePost(@PathVariable long id, @RequestBody PostDTO postDTO) throws NotFoundException {
        return postService.updatePost(id,   postDTO);
    }

}
