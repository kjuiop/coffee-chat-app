package io.gig.coffeechat.domain.member.mentor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : JAKE
 * @date : 2022/12/22
 */
@Service
@RequiredArgsConstructor
public class MentorServiceImpl implements MentorService {

    @Override
    public boolean changeSchoolName(String uuid, MentorCommand.ChangeSchoolName request) {
        return true;
    }


}
