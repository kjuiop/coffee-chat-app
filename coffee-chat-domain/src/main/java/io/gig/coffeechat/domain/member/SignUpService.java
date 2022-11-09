package io.gig.coffeechat.domain.member;

import io.gig.coffeechat.domain.member.mentee.MenteeCommand;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
public interface SignUpService {

    String menteeSignUp(String uuid, MenteeCommand.SignUp signUpInfo);

}
