package io.gig.coffeechat.domain.member;

import io.gig.coffeechat.domain.member.mentee.MenteeSignUpService;
import io.gig.coffeechat.domain.member.mentor.MentorSignUpService;
import io.gig.coffeechat.domain.member.parent.ParentSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Component
@RequiredArgsConstructor
public class SignUpServiceFactory {

    private final MenteeSignUpService menteeSignUpService;
    private final MentorSignUpService mentorSignUpService;
    private final ParentSignUpService parentSignUpService;

    public SignUpService create(MemberCommand.SignUp signUpInfo) {

        switch (signUpInfo.getUsageAuthority()) {
            case MENTOR:
                return mentorSignUpService;
            case MENTEE:
                return menteeSignUpService;
            case PARENT:
                return parentSignUpService;
        }

        return null;
    }
}
