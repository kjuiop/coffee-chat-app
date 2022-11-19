package io.gig.coffeechat.service.api.dto.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author : JAKE
 * @date : 2022/11/18
 */
public class SignInDto {

    @Getter
    @NoArgsConstructor
    public static class SignIn {
        @NotBlank(message = "uuid 은 필수값입니다.")
        private String uuid;
    }

}
