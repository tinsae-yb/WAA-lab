package com.example.lab1.service;

import com.example.lab1.Utils.ListPostDTOMapper;
import com.example.lab1.domain.Post;
import com.example.lab1.dto.PostDTO;
import com.example.lab1.dto.PostsDTO;
import com.example.lab1.exception.NotFoundException;
import com.example.lab1.repo.PostRepository;
import com.example.lab1.repo.PostRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final ListPostDTOMapper listPostDTOMapper;


    public PostServiceImpl(PostRepositoryImpl postRepository, ModelMapper modelMapper, ListPostDTOMapper listPostDTOMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.listPostDTOMapper = listPostDTOMapper;
    }

    @Override
    public PostsDTO getAllPosts() {
        List<Post> posts = postRepository.getAllPosts();
        PostsDTO postsDTO = new PostsDTO();
        postsDTO.setPosts(listPostDTOMapper.postsToPostDTOsMapper(posts));
        return postsDTO;
    }

    @Override
    public PostDTO getPostById(long id) throws NotFoundException {
        Post post = postRepository.getPostById(id);
        PostDTO postDTO = modelMapper.map(post, PostDTO.class);
        return postDTO;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        post = postRepository.createPost(post);
        return modelMapper.map(post, PostDTO.class);
    }

    @Override
    public void deletePost(long id) {
        postRepository.deletePost(id);

    }

    @Override
    public PostDTO updatePost(long id, PostDTO postDTO) throws NotFoundException {
        Post post = modelMapper.map(postDTO, Post.class);
        Post p = postRepository.updatePost(id, post);

        return modelMapper.map(p, PostDTO.class);

    }
}
