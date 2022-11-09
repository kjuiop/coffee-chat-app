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
public enum UsageAuthorityType {

    MENTOR("MENTOR", "대학생"),

    MENTEE("MENTEE", "입시생"),

    PARENT("PARENT", "학부모");

    private String key;

    private String description;

}