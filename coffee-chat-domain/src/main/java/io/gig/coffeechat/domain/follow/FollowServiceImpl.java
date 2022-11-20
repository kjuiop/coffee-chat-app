package io.gig.coffeechat.domain.follow;

import io.gig.coffeechat.domain.member.Member;
import io.gig.coffeechat.domain.member.MemberInfo;
import io.gig.coffeechat.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : JAKE
 * @date : 2022/11/19
 */

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final FollowStore followStore;
    private final FollowReader followReader;
    private final MemberReader memberReader;

    @Override
    @Transactional(readOnly = true)
    public List<Long> getFollowingMemberUuids(String uuid) {
        Member findMember = memberReader.getMember(uuid);
        List<Follow> followingList = followReader.getFollowingList(findMember.getId());
        if (followingList.isEmpty()) {
            return List.of();
        }

        return followingList.stream().map(Follow::getToMemberId).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean create(MemberInfo.Main fromMember, MemberInfo.Main toMember) {
        validateFollowRequest(fromMember.getUuid(), toMember.getUuid());
        Follow newFollow = Follow.CreateFollow(fromMember, toMember);
        followStore.store(newFollow);
        return true;
    }

    private void validateFollowRequest(String fromUuid, String toUuid) {
        if (fromUuid.equals(toUuid)) {
            throw new InvalidParameterException("팔로우 요청 간 회원들의 uuid 가 동일할 수 없습니다. from uuid : " + fromUuid + " to uuid : " + toUuid);
        }
    }
}
