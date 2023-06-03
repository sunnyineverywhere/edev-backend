package api.edev.domain.post.storage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    RETROSPECT("회고", "회고성 기술블로그"),
    ARTICLE("정리", "일반 기술을 정리한 기술블로그"),
    REVIEW("후기", "기술 세션, 세미나 등에 대한 후기"),
    ETC("일반", "이외, 카테고리에 속하지 않음");

    private final String title;
    private final String description;
}
