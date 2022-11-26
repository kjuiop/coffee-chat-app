package io.gig.coffeechat.service.api.dto.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

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
    @NoArgsConstructor
    public static class ChangeNicknameRequest {
        private String nickname;
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
