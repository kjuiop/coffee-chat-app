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
    public static class Main {
        private final Long memberId;
        private final String uuid;
        private final String nickname;
    }

    @Getter
    @Builder
    public static class ValidateResponse {
        private final Boolean isValid;
    }

    @Getter
    @Builder
    public static class Response {
        private final Boolean isOk;
    }

}
