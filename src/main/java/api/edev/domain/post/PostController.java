package api.edev.domain.post;

import api.edev.domain.member.storage.AuthMember;
import api.edev.domain.member.storage.Member;
import api.edev.domain.post.dto.PostReq;
import api.edev.domain.post.dto.PostRes;
import api.edev.domain.post.service.PostService;
import api.edev.domain.post.storage.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> postAdd(@AuthMember Member member, @RequestBody PostReq request) {
        Post post = postService.addPost(member, request);
        return new ResponseEntity<>(new PostRes(post), HttpStatus.CREATED);
    }
}
