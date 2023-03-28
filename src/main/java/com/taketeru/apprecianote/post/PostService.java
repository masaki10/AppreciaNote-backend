package com.taketeru.apprecianote.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> fetchAllPosts(){
        return postRepository.findAll();
    }

    public Post createPost(Post post) {
        // TODO; post の中身確認して、例外処理とかも実装する
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        // TODO; 存在確認
        postRepository.deleteById(id);
    }
}
