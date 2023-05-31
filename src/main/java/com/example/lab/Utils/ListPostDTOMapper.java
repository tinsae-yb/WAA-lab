package com.example.lab1.Utils;


import com.example.lab1.domain.Post;
import com.example.lab1.dto.PostDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListPostDTOMapper {

    private final ModelMapper modelMapper;

    public ListPostDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<PostDTO> postsToPostDTOsMapper(List<Post> posts) {
        return posts.stream().map(p -> modelMapper.map(p, PostDTO.class)).collect(Collectors.toList());
    }


}
