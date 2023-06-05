package api.edev.domain.member;

import api.edev.domain.member.service.MemberService;
import api.edev.domain.member.storage.AuthMember;
import api.edev.domain.member.storage.Member;
import api.edev.global.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<?> currentMemberInfoFind(@AuthMember Member member) {
        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
