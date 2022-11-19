package io.gig.coffeechat.service.api.dto.follow;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * @author : JAKE
 * @date : 2022/11/19
 */
public class FollowDto {

    @Getter
    @Builder
    public static class FollowRequest {

        @NotNull(message = "fromMemberUuid 는 필수값입니다.")
        private String fromMemberUuid;

        @NotNull(message = "toMemberUuid 는 필수값입니다.")
        private String toMemberUuid;
    }

    @Getter
    @Builder
    public static class Response {
        private final Boolean isOk;
    }
}
