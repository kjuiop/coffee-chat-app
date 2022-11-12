package io.gig.coffeechat.service.api.dto.member;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * @author : JAKE
 * @date : 2022/11/12
 */
public class MemberDto {

    @Getter
    @Builder
    public static class EmailValidateRequest {
        @NotBlank(message = "email 은 필수값입니다.")
        private String email;
    }

    @Getter
    @Builder
    public static class ValidateResponse {
        private final boolean isValid;
    }

}
