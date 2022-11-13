package io.gig.coffeechat.domain.member;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
public interface MemberReader {
    boolean isExistUuId(String uuid);
    boolean isExistEmail(String email);
    boolean isExistNickname(String nickname);
    Member getMember(String uuid);
}
