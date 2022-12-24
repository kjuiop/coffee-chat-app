package io.gig.coffeechat.domain.attachment.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : JAKE
 * @date : 2022/12/13
 */
@Getter
@AllArgsConstructor
public enum UsageType {

    Profile("profile", "프로필 이미지");

    final private String type;
    final private String description;
}
