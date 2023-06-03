package api.edev.domain.post.storage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    CREATED("생성", "최초 생성 후 변경 없음"),
    MODIFIED("변경", "최초 생성 후 1회 이상 변경됨"),
    DELETED("삭제", "삭제된 상태");

    private final String title;
    private final String description;
}
