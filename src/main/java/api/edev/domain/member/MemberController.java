package api.edev.domain.member;

import api.edev.domain.member.dto.MemberInfoModifyReq;
import api.edev.domain.member.dto.MemberRes;
import api.edev.domain.member.service.MemberService;
import api.edev.domain.member.storage.AuthMember;
import api.edev.domain.member.storage.Member;
import api.edev.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PostService postService;

    @GetMapping
    public ResponseEntity<?> currentMemberInfoFind(@AuthMember Member member) {
        return new ResponseEntity<>(new MemberRes(member, postService.findPostByAuthor(member)), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> modifyMemberInfo(@AuthMember Member member, @RequestBody MemberInfoModifyReq request) {
        memberService.modifyMemberInfo(member, request);
        return new ResponseEntity<>("성공적으로 변경되었습니다.", HttpStatus.OK);
    }
}
