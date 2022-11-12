package io.gig.coffeechat.domain.member.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum GenderType {

    M("M", "남자"),

    W("W", "여자"),

    ETC("ETC", "기타");

    private String key;

    private String description;
}
