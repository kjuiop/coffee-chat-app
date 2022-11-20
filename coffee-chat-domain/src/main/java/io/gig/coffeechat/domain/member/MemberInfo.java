package io.gig.coffeechat.domain.member;

import lombok.Builder;
import lombok.Getter;

/**
 * @author : JAKE
 * @date : 2022/11/19
 */
public class MemberInfo {

    @Getter
    @Builder
    public static class Main {
        private final Long memberId;
        private final String uuid;
        private final String nickname;

        public Main(Long memberId, String uuid, String nickname) {
            this.memberId = memberId;
            this.uuid = uuid;
            this.nickname = nickname;
        }
    }

}
