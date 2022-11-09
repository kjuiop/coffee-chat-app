package io.gig.coffeechat.service.api.facade;

import io.gig.coffeechat.domain.member.SignUpService;
import io.gig.coffeechat.domain.member.mentee.MenteeCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Service
@RequiredArgsConstructor
public class MenteeFacade {

    private final SignUpService signUpService;

    public String signUp(String uuid, MenteeCommand.SignUp signUpInfo) {
        return signUpService.menteeSignUp(uuid, signUpInfo);
    }

}
