package api.edev.global.oauth;

import api.edev.domain.member.storage.Member;
import api.edev.domain.member.storage.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final MemberRepository memberRepository;
    private static String EMAIL_EWHA_SUFFIX = "ewhain.net";

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User authUser = super.loadUser(userRequest);

        String userNameAttributesName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        Member member = loadOrUpdateMember(
                userNameAttributesName, authUser
        );

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                authUser.getAttributes(),
                userNameAttributesName
        );
    }

    public Member loadOrUpdateMember(String attributes, OAuth2User authUser) {
        log.info("Attributes : " + attributes);
        log.info("OAuth2User Info : " + authUser.toString());

        if (!Objects.equals((String) authUser.getAttribute("hd"), EMAIL_EWHA_SUFFIX)) {
            throw new IllegalArgumentException(
                    "이화인 계정이 아닙니다. 이화인 계정으로 다시 로그인해 주세요."
            );
        }

        Member member = memberRepository.findByEmail((String) authUser.getAttribute("email"))
                .orElse(
                        Member.builder()
                        .name((String) authUser.getAttribute("name"))
                        .email((String) authUser.getAttribute("email"))
                        .profile((String) authUser.getAttribute("picture"))
                        .build()
                );

        return memberRepository.save(member);
    }
}
