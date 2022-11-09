package io.gig.coffeechat.service.api.facade;

import io.gig.coffeechat.domain.member.SignUpService;
import io.gig.coffeechat.domain.member.mentor.MentorCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Service
@RequiredArgsConstructor
public class MentorFacade {

    private final SignUpService signUpService;

    public String signUp(String uuid, MentorCommand.SignUp signUpInfo) {
        return signUpService.mentorSignUp(uuid, signUpInfo);
    }

}
