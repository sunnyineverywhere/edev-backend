package api.edev.domain.post.service;

import api.edev.domain.member.storage.Member;
import api.edev.domain.member.storage.MemberRepository;
import api.edev.domain.post.storage.Category;
import api.edev.domain.post.storage.Post;
import api.edev.domain.post.storage.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public void addTestPost() {
        Member member = memberRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("memberId가 잘못되었습니다."));
        postRepository.save(Post.builder()
                .author(member)
                .category(Category.RETROSPECT)
                .url("url")
                .contents("contents")
                .isPublic(Boolean.TRUE)
                .title("title").build());
    }
}
