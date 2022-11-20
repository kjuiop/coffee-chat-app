package io.gig.coffeechat.domain.follow;

import lombok.Builder;
import lombok.Getter;

/**
 * @author : JAKE
 * @date : 2022/11/19
 */
public class FollowCommand {

    @Getter
    @Builder
    public static class FromFollow {
        private final Long memberId;
    }

    @Getter
    @Builder
    public static class ToFollow {
        private final Long memberId;
    }
}
