package com.example.lab1.repo;

import com.example.lab1.domain.Post;
import com.example.lab1.exception.NotFoundException;

import java.util.List;

public interface PostRepository {


    List<Post> getAllPosts();

    Post getPostById(long id) throws NotFoundException;

    Post createPost(Post post);

    void deletePost(long id);

    Post updatePost(long id, Post post) throws NotFoundException;
}
