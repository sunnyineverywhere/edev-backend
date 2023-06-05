package api.edev.domain.post.dto;

import api.edev.domain.post.storage.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class PostResList {
    private List<PostRes> hot;
    private List<PostRes> retrospect;
    private List<PostRes> article;
    private List<PostRes> review;

    public PostResList (
            List<Post> hotList,
            List<Post> retrospectList,
            List<Post> articleList,
            List<Post> reviewList
    ) {
        this.hot = hotList.stream().map(PostRes::new).collect(Collectors.toList());
        this.retrospect = retrospectList.stream().map(PostRes::new).collect(Collectors.toList());
        this.article = articleList.stream().map(PostRes::new).collect(Collectors.toList());
        this.review = reviewList.stream().map(PostRes::new).collect(Collectors.toList());
    }
}
