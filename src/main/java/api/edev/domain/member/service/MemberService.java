package api.edev.domain.member.service;

import api.edev.domain.member.dto.MemberInfoModifyReq;
import api.edev.domain.member.storage.Member;
import api.edev.domain.member.storage.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void modifyMemberInfo(Member member, MemberInfoModifyReq request) {
        member.modifyMemberInfo(request.getName());
        memberRepository.save(member);
    }
}
