package api.edev.domain.post.storage;

import api.edev.domain.member.storage.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByAuthorOrderByCreatedAtDesc(Member member);
    List<Post> findAllByCategoryAndIsPublicOrderByCreatedAtDesc(Category category, Boolean isPublic);
}
