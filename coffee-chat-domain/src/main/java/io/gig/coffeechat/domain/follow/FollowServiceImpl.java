package io.gig.coffeechat.domain.follow;

import io.gig.coffeechat.domain.member.MemberInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;

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
        validateFollowRequest(fromMember.getUuid(), toMember.getUuid());
        Follow newFollow = Follow.CreateFollow(fromMember, toMember);
        followStore.store(newFollow);
    }

    private void validateFollowRequest(String fromUuid, String toUuid) {
        if (fromUuid.equals(toUuid)) {
            throw new InvalidParameterException("팔로우 요청 간 회원들의 uuid 가 동일할 수 없습니다. from uuid : " + fromUuid + " to uuid : " + toUuid);
        }
    }
}
