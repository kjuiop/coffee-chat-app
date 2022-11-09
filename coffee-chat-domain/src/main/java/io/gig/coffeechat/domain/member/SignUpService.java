package io.gig.coffeechat.domain.member;

import io.gig.coffeechat.domain.member.mentee.MenteeCommand;
import io.gig.coffeechat.domain.member.mentor.MentorCommand;
import io.gig.coffeechat.domain.member.parent.ParentCommand;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
public interface SignUpService {

    String menteeSignUp(String uuid, MenteeCommand.SignUp signUpInfo);

    String mentorSignUp(String uuid, MentorCommand.SignUp signUpInfo);

    String parentSignUp(String uuid, ParentCommand.SignUp signUpInfo);
}
