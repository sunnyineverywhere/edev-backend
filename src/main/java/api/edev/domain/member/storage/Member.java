package api.edev.domain.member.storage;

import api.edev.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String profile;

    @Builder
    public Member(String email, String name, String profile) {
        this.email = email;
        this.name = name;
        this.profile = profile;
    }
}
