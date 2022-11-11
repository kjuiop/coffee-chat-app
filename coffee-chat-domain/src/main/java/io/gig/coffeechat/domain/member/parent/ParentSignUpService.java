package io.gig.coffeechat.domain.member.parent;

import io.gig.coffeechat.domain.member.Member;
import io.gig.coffeechat.domain.member.MemberCommand;
import io.gig.coffeechat.domain.member.MemberStore;
import io.gig.coffeechat.domain.member.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Service
@RequiredArgsConstructor
public class ParentSignUpService implements SignUpService {

    private final MemberStore memberStore;

    @Override
    public String signUp(String uuid, MemberCommand.SignUp signUpInfo) {
        ParentDetail parentDetail = ParentDetail.createParentDetail(signUpInfo.getParentDetailInfo());
        parentDetail.validateYear(signUpInfo.getParentDetailInfo().getYear());
        Member newParent = Member.ParentSignUp(uuid, signUpInfo, parentDetail);
        Member savedParent = memberStore.store(newParent);
        return savedParent.getUuid();
    }
}
