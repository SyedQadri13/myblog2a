package com.myblog.myblog2.controller;

import com.myblog.myblog2.payload.PostDto;
import com.myblog.myblog2.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private PostService pS;

    public PostController(PostService pS) {
        this.pS = pS;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto dto = pS.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
