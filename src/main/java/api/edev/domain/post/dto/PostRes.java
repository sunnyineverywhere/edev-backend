package api.edev.domain.post.dto;

import api.edev.domain.post.storage.Post;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostRes {
    private String author;
    private Long postId;
    private String title;
    private String contents;
    private String url;
    private String category;
    private Boolean isPublic;

    public PostRes(Post post) {
        this.author = post.getAuthor().getEmail();
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.url = post.getUrl();
        this.category = post.getCategory().name();
        this.isPublic = post.getIsPublic();
    }
}
