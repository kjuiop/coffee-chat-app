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

    public boolean changeSchoolName(String uuid, ParentCommand.ChangeSchoolName request) {
        return parentService.changeSchoolName(uuid, request);
    }
}
