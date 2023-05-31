package com.example.lab1.repo;

import com.example.lab1.domain.Post;
import com.example.lab1.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PostRepositoryImpl implements PostRepository {

    private static final List<Post> posts = new ArrayList<>();

    @Override
    public List<Post> getAllPosts() {
        return posts;
    }

    @Override
    public Post getPostById(long id) throws NotFoundException {
        return posts.stream().filter((p) -> p.getId() == id).findFirst().orElseThrow(() -> new NotFoundException("Post not found"));
    }

    @Override
    public Post createPost(Post post) {
        posts.add(post);
        return post;
    }

    @Override
    public void deletePost(long id) {
        posts.removeIf((p) -> id == p.getId());
    }

    @Override
    public Post updatePost(long id, Post post) throws NotFoundException {
        Post p = posts.stream().filter((po) -> po.getId() == id).findFirst().orElseThrow(() -> new NotFoundException("Post not found"));
        p.setId(id);
        p.setTitle(post.getTitle());
        p.setContent(post.getContent());
        p.setAuthor(post.getAuthor());

        return p;

    }
}
