package api.edev.domain.member;

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
}
