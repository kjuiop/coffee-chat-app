package io.gig.coffeechat.service.api.facade;

import io.gig.coffeechat.domain.member.MemberCommand;
import io.gig.coffeechat.domain.member.MemberService;
import io.gig.coffeechat.domain.member.SignUpService;
import io.gig.coffeechat.domain.member.SignUpServiceFactory;
import io.gig.coffeechat.domain.role.Role;
import io.gig.coffeechat.domain.role.RoleService;
import io.gig.coffeechat.service.api.dto.member.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

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

    public boolean login(MemberCommand.SignIn request) {
        return memberService.login(request);
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

    public boolean changeNickname(String uuid, MemberCommand.ChangeNickname request) {
        return memberService.changeNickname(uuid, request);
    }
}
