package io.gig.coffeechat.domain.common;

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
public enum YnType {

    Y("Y", "Y"),

    N("N", "N");

    private String key;

    private String description;
}
