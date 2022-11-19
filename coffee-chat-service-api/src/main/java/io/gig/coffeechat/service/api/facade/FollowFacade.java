package io.gig.coffeechat.service.api.facade;

import io.gig.coffeechat.domain.follow.FollowService;
import io.gig.coffeechat.domain.member.MemberInfo;
import io.gig.coffeechat.domain.member.MemberService;
import io.gig.coffeechat.service.api.dto.follow.FollowDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : JAKE
 * @date : 2022/11/19
 */
@Service
@RequiredArgsConstructor
public class FollowFacade {

    private final MemberService memberService;
    private final FollowService followService;

    public void execute(FollowDto.FollowRequest request) {
        MemberInfo.Main fromMember = memberService.getMember(request.getFromMemberUuid());
        MemberInfo.Main toMember = memberService.getMember(request.getToMemberUuid());

        followService.create(fromMember, toMember);
    }
}
