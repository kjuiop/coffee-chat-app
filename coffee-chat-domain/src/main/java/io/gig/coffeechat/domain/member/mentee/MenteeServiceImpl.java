package io.gig.coffeechat.domain.member.mentee;

import io.gig.coffeechat.domain.member.Member;
import io.gig.coffeechat.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : JAKE
 * @date : 2022/12/24
 */
@Service
@RequiredArgsConstructor
public class MenteeServiceImpl implements MenteeService {

    private final MenteeStore menteeStore;
    private final MemberReader memberReader;

    @Override
    @Transactional
    public boolean changeSchoolName(String uuid, MenteeCommand.ChangeSchoolName request) {

        Member findMember = memberReader.getMember(uuid);
        MenteeDetail findMenteeDetail = findMember.getMenteeDetail();
        findMenteeDetail.changeSchoolName(request.getSchoolName());
        menteeStore.store(findMenteeDetail);

        return true;
    }

    @Override
    @Transactional
    public boolean changeYear(String uuid, MenteeCommand.ChangeYear request) {

        Member findMember = memberReader.getMember(uuid);
        MenteeDetail findMenteeDetail = findMember.getMenteeDetail();
        findMenteeDetail.validateYear(request.getYear());
        findMenteeDetail.changeYear(request.getYear());
        menteeStore.store(findMenteeDetail);
        return true;
    }
}
