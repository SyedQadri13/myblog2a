package com.myblog.myblog2.service.impl;

import com.myblog.myblog2.entity.Post;
import com.myblog.myblog2.payload.PostDto;
import com.myblog.myblog2.repository.PostRepository;
import com.myblog.myblog2.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

private PostRepository pR;

    public PostServiceImpl(PostRepository pR) {
        this.pR = pR;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post p = new Post();
        p.setTitle(postDto.getTitle());
        p.setDescription(postDto.getDescription());
        p.setContent(postDto.getContent());
        Post saved = pR.save(p);

        PostDto dto = new PostDto();
        dto.setTitle(saved.getTitle());
        dto.setDescription(saved.getDescription());
        dto.setContent(saved.getContent());

        return dto;
    }
}
