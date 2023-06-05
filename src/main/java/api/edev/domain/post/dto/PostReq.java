package api.edev.domain.post.dto;

import lombok.Getter;

@Getter
public class PostReq {
    private String title;
    private String contents;
    private String url;
    private String category;
    private Boolean isPublic;
}
