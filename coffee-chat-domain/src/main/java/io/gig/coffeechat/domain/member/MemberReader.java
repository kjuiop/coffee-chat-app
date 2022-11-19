package io.gig.coffeechat.domain.member;

import java.util.List;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
public interface MemberReader {
    boolean isExistUuId(String uuid);
    boolean isExistEmail(String email);
    boolean isExistNickname(String nickname);
    Member getMember(String uuid);
    List<Member> findAllByMemberIdsIn(List<Long> memberIds);
}
