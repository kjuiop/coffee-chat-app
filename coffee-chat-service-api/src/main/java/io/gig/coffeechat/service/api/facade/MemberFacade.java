package io.gig.coffeechat.service.api.facade;

import io.gig.coffeechat.domain.member.*;
import io.gig.coffeechat.domain.role.Role;
import io.gig.coffeechat.domain.role.RoleService;
import io.gig.coffeechat.service.api.dto.member.MemberDto;
import io.gig.coffeechat.service.api.jwt.TokenProvider;
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
    private final TokenProvider tokenProvider;

    public MemberInfo.Main signUp(String uuid, MemberCommand.SignUp request) {
        SignUpService signUpService = signUpServiceFactory.create(request);
        MemberInfo.Main memberInfo = signUpService.signUp(uuid, request);
        String accessToken = tokenProvider.createAccessToken(memberInfo.getUuid(), memberInfo.getRoles());
        String refreshToken = tokenProvider.createRefreshToken(memberInfo.getUuid(), memberInfo.getRoles());
        memberInfo.setTokenInfo(accessToken, refreshToken);
        return memberInfo;
    }

    public MemberInfo.TokenInfo login(MemberCommand.SignIn request) {
        MemberInfo.Main memberInfo = memberService.getMember(request.getUuid());
        String accessToken = tokenProvider.createAccessToken(memberInfo.getUuid(), memberInfo.getRoles());
        String refreshToken = tokenProvider.createRefreshToken(memberInfo.getUuid(), memberInfo.getRoles());

        boolean isLogin = memberService.login(request, refreshToken);
        if (!isLogin) {
            return null;
        }
        return new MemberInfo.TokenInfo(accessToken, refreshToken);
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

    public boolean changeProfileImage(String uuid, MemberCommand.ChangeProfileImage request) {
        return memberService.changeProfileImage(uuid, request);
    }

    public boolean changeMarketingApprove(String uuid, MemberCommand.ChangeMarketingApprove request) {
        return memberService.changeMarketingApprove(uuid, request);
    }
}
