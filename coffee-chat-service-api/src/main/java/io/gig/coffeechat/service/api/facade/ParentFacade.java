package io.gig.coffeechat.service.api.facade;

import io.gig.coffeechat.domain.member.SignUpService;
import io.gig.coffeechat.domain.member.parent.ParentCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Service
@RequiredArgsConstructor
public class ParentFacade {

    private final SignUpService signUpService;

    public String signUp(String uuid, ParentCommand.SignUp signUpInfo) {
        return signUpService.parentSignUp(uuid, signUpInfo);
    }

}
