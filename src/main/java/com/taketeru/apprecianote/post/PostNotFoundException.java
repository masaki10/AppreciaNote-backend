package com.taketeru.apprecianote.post;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(Long id) {
        super ("Post could not found post " + id);
    }
}
