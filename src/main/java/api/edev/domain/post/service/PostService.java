package api.edev.domain.post.service;

import api.edev.domain.member.storage.Member;
import api.edev.domain.member.storage.MemberRepository;
import api.edev.domain.post.dto.PostReq;
import api.edev.domain.post.storage.Category;
import api.edev.domain.post.storage.Post;
import api.edev.domain.post.storage.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public Post addPost(Member member, PostReq request) {
        Post post = Post.builder()
                .author(member)
                .title(request.getTitle())
                .contents(request.getContents())
                .url(request.getUrl())
                .isPublic(request.getIsPublic())
                .category(Category.valueOf(request.getCategory()))
                .build();
        return postRepository.save(post);
    }
}
