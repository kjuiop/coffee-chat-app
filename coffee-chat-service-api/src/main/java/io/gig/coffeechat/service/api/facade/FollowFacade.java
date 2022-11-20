package io.gig.coffeechat.service.api.facade;

import io.gig.coffeechat.domain.follow.FollowService;
import io.gig.coffeechat.domain.member.MemberInfo;
import io.gig.coffeechat.domain.member.MemberService;
import io.gig.coffeechat.service.api.dto.follow.FollowDto;
import io.gig.coffeechat.service.api.dto.member.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : JAKE
 * @date : 2022/11/19
 */
@Service
@RequiredArgsConstructor
public class FollowFacade {

    private final MemberService memberService;
    private final FollowService followService;

    public boolean create(FollowDto.FollowRequest request) {
        MemberInfo.Main fromMember = memberService.getMember(request.getFromMemberUuid());
        MemberInfo.Main toMember = memberService.getMember(request.getToMemberUuid());
        return followService.create(fromMember, toMember);
    }

    public List<MemberInfo.Main> getFollowingList(String uuid) {
        List<Long> followingMemberIds = followService.getFollowingMemberUuids(uuid);
        return memberService.getMembers(followingMemberIds);
    }
}
