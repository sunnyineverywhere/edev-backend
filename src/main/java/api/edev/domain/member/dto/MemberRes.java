package api.edev.domain.member.dto;

import api.edev.domain.member.storage.Member;
import api.edev.domain.post.dto.PostRes;
import api.edev.domain.post.storage.Post;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberRes {
    private String name;
    private String email;
    private List<PostRes> postList;

    public MemberRes(Member member, List<Post> posts) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.postList = posts.stream().map(PostRes::new).collect(Collectors.toList());
    }
}
