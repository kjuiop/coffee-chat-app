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
public enum StudentType {

    HIGH_SCHOOL_STUDENT("HIGH_SCHOOL_STUDENT", "입시생"),

    REPEATER_STUDENT("REPEATER_STUDENT", "N수생"),

    CERTIFICATION_STUDENT("EXAM_STUDENT", "검정고시생");

    private String key;

    private String description;
}
