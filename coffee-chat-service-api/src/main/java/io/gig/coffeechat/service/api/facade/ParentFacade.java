package io.gig.coffeechat.service.api.facade;

import io.gig.coffeechat.domain.member.parent.ParentCommand;
import io.gig.coffeechat.domain.member.parent.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : JAKE
 * @date : 2022/12/24
 */
@Service
@RequiredArgsConstructor
public class ParentFacade {

    private final ParentService parentService;

    public boolean changeHighSchool(String uuid, ParentCommand.ChangeHighSchool request) {
        return parentService.changeHighSchool(uuid, request);
    }

    public boolean changeYear(String uuid, ParentCommand.ChangeYear request) {
        return parentService.changeYear(uuid, request);
    }

}
