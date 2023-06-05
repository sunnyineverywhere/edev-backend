package api.edev.domain.post.service;

import api.edev.domain.member.storage.Member;
import api.edev.domain.member.storage.MemberRepository;
import api.edev.domain.post.dto.PostReq;
import api.edev.domain.post.dto.PostRes;
import api.edev.domain.post.dto.PostResList;
import api.edev.domain.post.storage.Category;
import api.edev.domain.post.storage.Post;
import api.edev.domain.post.storage.PostRepository;
import api.edev.domain.post.storage.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    public List<Post> findPostByAuthor(Member member) {
        return postRepository.findAllByAuthorOrderByCreatedAtDesc(member);
    }

    @Transactional(readOnly = true)
    public PostResList findPostByCategory() {
        return new PostResList(
                postRepository.findAllByIsPublicAndStatusIsNotOrderByCreatedAtDesc(true, Status.DELETED),
                postRepository.findAllByCategoryAndIsPublicAndStatusIsNotOrderByCreatedAtDesc(Category.RETROSPECT, true, Status.DELETED),
                postRepository.findAllByCategoryAndIsPublicAndStatusIsNotOrderByCreatedAtDesc(Category.ARTICLE, true, Status.DELETED),
                postRepository.findAllByCategoryAndIsPublicAndStatusIsNotOrderByCreatedAtDesc(Category.REVIEW, true, Status.DELETED)
        );
    }
}
