package com.example.lab1.service;

import com.example.lab1.domain.Post;
import com.example.lab1.dto.PostDTO;
import com.example.lab1.dto.PostsDTO;
import com.example.lab1.exception.NotFoundException;

import java.util.List;

public interface PostService {

    PostsDTO getAllPosts();

    PostDTO getPostById(long id) throws NotFoundException;

    PostDTO createPost(PostDTO postDTO);

    void deletePost(long id);


    PostDTO updatePost(long id, PostDTO postDTO) throws NotFoundException;
}
