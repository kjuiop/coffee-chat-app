package io.gig.coffeechat.domain.member.mentor;

import io.gig.coffeechat.domain.member.Member;
import io.gig.coffeechat.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : JAKE
 * @date : 2022/12/22
 */
@Service
@RequiredArgsConstructor
public class MentorServiceImpl implements MentorService {

    private final MentorStore mentorStore;
    private final MemberReader memberReader;

    @Override
    @Transactional
    public boolean changeUniversity(String uuid, MentorCommand.ChangeUniversity request) {

        // 회원이 Mentor 인지 Validation

        Member findMember = memberReader.getMember(uuid);
        MentorDetail findMentorDetail = findMember.getMentorDetail();
        findMentorDetail.changeUniversity(request.getUniversity());
        mentorStore.store(findMentorDetail);

        return true;
    }

    @Override
    @Transactional
    public boolean changeYear(String uuid, MentorCommand.ChangeYear request) {

        Member findMember = memberReader.getMember(uuid);
        MentorDetail findMentorDetail = findMember.getMentorDetail();
        findMentorDetail.validateYear(request.getYear());
        findMentorDetail.changeYear(request.getYear());
        mentorStore.store(findMentorDetail);

        return true;
    }
}
