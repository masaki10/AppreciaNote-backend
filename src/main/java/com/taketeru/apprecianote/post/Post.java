package com.taketeru.apprecianote.post;

import com.taketeru.apprecianote.like.Like;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length=400)
    private String content;

    @Column(nullable = false)
    private String userInfo;

    @OneToMany(mappedBy = "postId", fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @Fetch(FetchMode.JOIN)
    private List<Like> likes;
}
