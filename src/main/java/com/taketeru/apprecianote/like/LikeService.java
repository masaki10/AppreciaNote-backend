package com.taketeru.apprecianote.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    @Autowired
    LikeRepository likeRepository;

    public Like createLike(Like like) {
        // TODO; like の中身確認して、例外処理とかも実装する
        return likeRepository.save(like);
    }

    public void deleteLike(Long id) {
        // TODO; 存在確認
        likeRepository.deleteById(id);
    }
}
