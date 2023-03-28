package com.taketeru.apprecianote.like;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
}
