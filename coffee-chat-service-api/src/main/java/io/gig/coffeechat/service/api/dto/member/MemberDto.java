package io.gig.coffeechat.service.api.dto.member;

import lombok.Builder;
import lombok.Getter;

/**
 * @author : JAKE
 * @date : 2022/11/12
 */
public class MemberDto {

    @Getter
    @Builder
    public static class ValidateResponse {
        private final Boolean isValid;
    }

}
