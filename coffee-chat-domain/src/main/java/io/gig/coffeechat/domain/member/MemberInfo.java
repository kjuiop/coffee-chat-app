package io.gig.coffeechat.domain.member;

import io.gig.coffeechat.domain.follow.Follow;
import io.gig.coffeechat.domain.member.memberRole.MemberRole;
import io.gig.coffeechat.domain.role.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : JAKE
 * @date : 2022/11/19
 */
public class MemberInfo {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Main {
        private final Long memberId;
        private final String uuid;
        private final String nickname;
        private List<String> roles;
        private String accessToken;
        private String refreshToken;

        public Main(Long memberId, String uuid, String nickname) {
            this.memberId = memberId;
            this.uuid = uuid;
            this.nickname = nickname;
        }

        public Main(Member member) {
            this.memberId = member.getId();
            this.uuid = member.getUuid();
            this.nickname = member.getNickname();
            this.roles = member.getMemberRoles().stream().map(MemberRole::getRoleName).collect(Collectors.toList());
        }

        public void setTokenInfo(String accessToken, String refreshToken) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        }
    }

    @Getter
    @Builder
    public static class TokenInfo {
        private final String accessToken;
        private final String refreshToken;

        public TokenInfo(String accessToken, String refreshToken) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        }
    }

}
