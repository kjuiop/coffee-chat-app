package io.gig.coffeechat.domain.member;

import java.util.List;

/**
 * @author : JAKE
 * @date : 2022/11/12
 */
public interface MemberService {

    boolean login(MemberCommand.SignIn request);

    boolean validateEmail(String email);

    boolean validateNickname(String nickname);

    void authMemberEmailValidate(String uuid);

    MemberInfo.Main getMember(String uuid);

    List<MemberInfo.Main> getMembers(List<Long> followingMemberIds);

    boolean changeNickname(String uuid, MemberCommand.ChangeNickname request);

    boolean changeProfileImage(String uuid, MemberCommand.ChangeProfileImage request);

    boolean changeMarketingApprove(String uuid, MemberCommand.ChangeMarketingApprove request);
}
