package io.gig.coffeechat.service.api.facade;

import io.gig.coffeechat.domain.member.MemberCommand;
import io.gig.coffeechat.domain.member.MemberService;
import io.gig.coffeechat.domain.member.SignUpService;
import io.gig.coffeechat.domain.member.SignUpServiceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Service
@RequiredArgsConstructor
public class MemberFacade {

    private final SignUpServiceFactory signUpServiceFactory;
    private final MemberService memberService;

    public String signUp(String uuid, MemberCommand.SignUp request) {
        SignUpService signUpService = signUpServiceFactory.create(request);
        return signUpService.signUp(uuid, request);
    }

    public void authMemberEmailValidate(String uuid) {
        memberService.authMemberEmailValidate(uuid);
    }

    public boolean validateEmail(String email) {
        return memberService.validateEmail(email);
    }

    public boolean validateNickname(String nickname) {
        return memberService.validateNickname(nickname);
    }


}
