package com.taketeru.apprecianote.post;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
