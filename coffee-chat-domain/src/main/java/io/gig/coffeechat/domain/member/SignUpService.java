package io.gig.coffeechat.domain.member;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@FunctionalInterface
public interface SignUpService {
    MemberInfo.Main signUp(String uuid, MemberCommand.SignUp signUp);
}
