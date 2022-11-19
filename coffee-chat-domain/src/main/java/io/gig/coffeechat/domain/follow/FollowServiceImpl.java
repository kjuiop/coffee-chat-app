package io.gig.coffeechat.domain.follow;

import io.gig.coffeechat.domain.member.MemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : JAKE
 * @date : 2022/11/19
 */

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final FollowStore followStore;

    @Override
    @Transactional
    public void create(MemberInfo.Main fromMember, MemberInfo.Main toMember) {
        Follow newFollow = Follow.CreateFollow(fromMember, toMember);
        followStore.store(newFollow);
    }
}
