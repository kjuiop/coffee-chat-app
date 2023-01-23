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

    public boolean changeHighSchool(String uuid, MenteeCommand.ChangeHighSchool request) {
        return menteeService.changeHighSchool(uuid, request);
    }

    public boolean changeYear(String uuid, MenteeCommand.ChangeYear request) {
        return menteeService.changeYear(uuid, request);
    }
}
