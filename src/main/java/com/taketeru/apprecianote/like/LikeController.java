package com.taketeru.apprecianote.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/v1/like")
public class LikeController {
    @Autowired
    LikeService likeService;

    @GetMapping()
    public List<Like> fetchAllLikes() {
        return likeService.fetchAllLikes();
    }

    @PostMapping()
    public Like createLike(@RequestBody Like like) { return likeService.createLike(like); }

    @DeleteMapping("{id}")
    public void deleteLike(@PathVariable Long id) { likeService.deleteLike(id); }
}
