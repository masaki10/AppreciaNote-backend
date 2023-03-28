package com.taketeru.apprecianote.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/post")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping()
    public List<Post> fetchAllPosts() { return postService.fetchAllPosts(); }

    @PostMapping()
    public Post createPost(@RequestBody Post post) { return postService.createPost(post); }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") Long id) { postService.deletePost(id); }
}
