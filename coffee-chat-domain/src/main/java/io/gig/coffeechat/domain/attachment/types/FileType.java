package io.gig.coffeechat.domain.attachment.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : JAKE
 * @date : 2022/12/13
 */
@Getter
@RequiredArgsConstructor
public enum FileType {

    Image("image", "이미지"),
    Video("video", "동영상"),
    Document("document", "문서");

    final private String type;
    final private String description;
}