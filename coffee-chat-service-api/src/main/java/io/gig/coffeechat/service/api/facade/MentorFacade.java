package io.gig.coffeechat.service.api.facade;

import io.gig.coffeechat.domain.member.MemberCommand;
import io.gig.coffeechat.domain.member.mentor.MentorCommand;
import io.gig.coffeechat.domain.member.mentor.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : JAKE
 * @date : 2022/12/22
 */
@Service
@RequiredArgsConstructor
public class MentorFacade {

    private final MentorService mentorService;

    public boolean changeSchoolName(String uuid, MentorCommand.ChangeSchoolName request) {
        return mentorService.changeSchoolName(uuid, request);
    }

}
