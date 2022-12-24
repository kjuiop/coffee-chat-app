package io.gig.coffeechat.service.api.facade;

import io.gig.coffeechat.domain.member.mentee.MenteeCommand;
import io.gig.coffeechat.domain.member.mentee.MenteeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : JAKE
 * @date : 2022/12/24
 */
@Service
@RequiredArgsConstructor
public class MenteeFacade {

    private final MenteeService menteeService;

    public boolean changeSchoolName(String uuid, MenteeCommand.ChangeSchoolName request) {
        return menteeService.changeSchoolName(uuid, request);
    }
}
