package io.gig.coffeechat.domain.member;

import io.gig.coffeechat.domain.member.mentee.MenteeCommand;
import io.gig.coffeechat.domain.member.mentee.MenteeDetail;
import io.gig.coffeechat.domain.member.mentor.MentorCommand;
import io.gig.coffeechat.domain.member.mentor.MentorDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final SignUpStore signUpStore;

    @Override
    @Transactional
    public String menteeSignUp(String uuid, MenteeCommand.SignUp signUpInfo) {
        MenteeDetail menteeDetail = MenteeDetail.createMenteeDetail(signUpInfo.getMenteeDetailInfo());
        Member newMentee = Member.MenteeSignUp(uuid, signUpInfo, menteeDetail);
        Member savedMentee = signUpStore.store(newMentee);
        return savedMentee.getUuid();
    }

    @Override
    @Transactional
    public String mentorSignUp(String uuid, MentorCommand.SignUp signUpInfo) {
        MentorDetail mentorDetail = MentorDetail.createMentorDetail(signUpInfo.getMentorDetailInfo());
        Member newMentor = Member.MentorSignUp(uuid, signUpInfo, mentorDetail);
        Member savedMentor = signUpStore.store(newMentor);
        return savedMentor.getUuid();
    }
}
