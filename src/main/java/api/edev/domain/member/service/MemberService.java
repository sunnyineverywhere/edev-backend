package api.edev.domain.member.service;

import api.edev.domain.member.dto.MemberInfoModifyReq;
import api.edev.domain.member.storage.Member;
import api.edev.domain.member.storage.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    public void addTestMember() {
        Member member = Member.builder()
                .email("abc@gmail.com")
                .name("abc")
                .profile("profile").build();
        memberRepository.save(member);
    }

    public void modifyMemberInfo(Member member, MemberInfoModifyReq request) {
        member.modifyMemberInfo(request.getName());
        memberRepository.save(member);
    }
}
