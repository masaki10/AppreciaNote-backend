package com.taketeru.apprecianote.like;

public class LikeAlreadyExistedException extends RuntimeException {
    LikeAlreadyExistedException(String userInfo, Long postId) {
        super("user " + userInfo + " have already liked to post " + postId);
    }
}
