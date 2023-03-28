package com.taketeru.apprecianote.like;

import com.taketeru.apprecianote.post.Post;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="likes")
public class Like {
    Like(String userInfo, Long postId) {
        if (userInfo == null) throw new NullPointerException("userInfo is null!!!");
        if (postId == null) throw new NullPointerException("postId is null");
        this.userInfo = userInfo;
        this.postId = postId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userInfo;

    @Column(nullable = false)
    private Long postId;
//    @ManyToOne
//    @JoinColumn(name = "post_id", insertable=false, updatable=false, nullable = false)
//    public Post post;
}
