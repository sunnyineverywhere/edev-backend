package api.edev.domain.post.storage;

import api.edev.domain.member.storage.Member;
import api.edev.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member author;

    @Column
    private String title;

    @Column
    private String contents;

    @Column
    private String url;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private Boolean isPublic;

    @Builder
    public Post(Member author, String title, String contents, String url, Category category, Boolean isPublic) {
        this.author = author;
        this.title = title;
        this.contents = contents;
        this.url = url;
        this.category = category;
        this.isPublic = isPublic;
        this.status = Status.CREATED;
    }

    public void delete() {
        this.status = Status.DELETED;
    }
}
