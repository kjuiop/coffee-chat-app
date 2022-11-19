package io.gig.coffeechat.domain.member;

/**
 * @author : JAKE
 * @date : 2022/11/12
 */
public interface MemberService {

    boolean login(MemberCommand.SignIn request);
    boolean validateEmail(String email);
    boolean validateNickname(String nickname);
    void authMemberEmailValidate(String uuid);
}
