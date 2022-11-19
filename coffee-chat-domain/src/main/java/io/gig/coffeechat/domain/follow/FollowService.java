package io.gig.coffeechat.domain.follow;

import io.gig.coffeechat.domain.member.MemberInfo;

/**
 * @author : JAKE
 * @date : 2022/11/19
 */
public interface FollowService {

    boolean create(MemberInfo.Main fromMember, MemberInfo.Main toMember);

}
