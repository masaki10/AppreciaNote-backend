package com.taketeru.apprecianote.like;

import com.taketeru.apprecianote.post.Post;
import com.taketeru.apprecianote.post.PostNotFoundException;
import com.taketeru.apprecianote.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    LikeRepository likeRepository;

    @Autowired
    PostRepository postRepository;

    public List<Like> fetchAllLikes() {
        return likeRepository.findAll();
    }

    public Like createLike(Like like) {
        // TODO; like の中身確認して、例外処理とかも実装する
        // TODO; like 存在確認
        Post post = postRepository.findById(like.getPostId()).orElseThrow(() -> new PostNotFoundException(like.getPostId()));
        if ( post == null) throw new PostNotFoundException(like.getPostId());
        Like existedLike = likeRepository.findByUserInfoAndPostId(like.getUserInfo(), like.getPostId());
        if (existedLike != null) throw new LikeAlreadyExistedException(like.getUserInfo(), like.getPostId());
        return likeRepository.save(like);
    }

    public void deleteLike(Long id) {
        // TODO; 存在確認
        likeRepository.deleteById(id);
    }
}
