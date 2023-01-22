package io.gig.coffeechat.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : JAKE
 * @date : 2023/01/22
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {

    UNAUTHORIZED_USER(403, "Unauthorized user");

    private int status;

    private String message;
}
