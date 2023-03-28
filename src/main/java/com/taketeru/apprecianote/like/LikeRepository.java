package com.taketeru.apprecianote.like;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
//    @EntityGraph(value = "like_post", type = EntityGraph.EntityGraphType.FETCH)
//    public List<Like> findAll();
    Like findByUserInfoAndPostId(String userInfo, Long postId);
}
