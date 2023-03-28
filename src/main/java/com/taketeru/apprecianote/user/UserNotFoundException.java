package com.taketeru.apprecianote.user;

public class UserNotFoundException extends RuntimeException{
    UserNotFoundException(Long id) {
        super("User could not found" + id);
    }
}
