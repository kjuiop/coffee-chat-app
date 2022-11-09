package io.gig.coffeechat.domain.member;

import io.gig.coffeechat.domain.member.mentee.MenteeCommand;
import io.gig.coffeechat.domain.member.mentee.MenteeDetail;
import io.gig.coffeechat.domain.member.mentor.MentorCommand;
import io.gig.coffeechat.domain.member.mentor.MentorDetail;
import io.gig.coffeechat.domain.member.parent.ParentCommand;
import io.gig.coffeechat.domain.member.parent.ParentDetail;
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

    private final MemberStore memberStore;
    private final MemberReader memberReader;

    @Override
    @Transactional
    public String menteeSignUp(String uuid, MenteeCommand.SignUp signUpInfo) {

        checkDuplicateUuid(uuid);
        MenteeDetail menteeDetail = MenteeDetail.createMenteeDetail(signUpInfo.getMenteeDetailInfo());
        menteeDetail.validateYear(signUpInfo.getMenteeDetailInfo().getYear());
        Member newMentee = Member.MenteeSignUp(uuid, signUpInfo, menteeDetail);
        Member savedMentee = memberStore.store(newMentee);
        return savedMentee.getUuid();
    }

    @Override
    @Transactional
    public String mentorSignUp(String uuid, MentorCommand.SignUp signUpInfo) {

        MentorDetail mentorDetail = MentorDetail.createMentorDetail(signUpInfo.getMentorDetailInfo());
        mentorDetail.validateYear(signUpInfo.getMentorDetailInfo().getYear());
        Member newMentor = Member.MentorSignUp(uuid, signUpInfo, mentorDetail);
        Member savedMentor = memberStore.store(newMentor);
        return savedMentor.getUuid();
    }

    @Override
    public String parentSignUp(String uuid, ParentCommand.SignUp signUpInfo) {

        ParentDetail parentDetail = ParentDetail.createParentDetail(signUpInfo.getParentDetailInfo());
        parentDetail.validateYear(signUpInfo.getParentDetailInfo().getYear());
        Member newParent = Member.ParentSignUp(uuid, signUpInfo, parentDetail);
        Member savedParent = memberStore.store(newParent);
        return savedParent.getUuid();
    }

    private void checkDuplicateUuid(String uuid) {
        boolean isDuplicated = memberReader.isExistUuId(uuid);
        if (isDuplicated) {
            throw new IllegalArgumentException("이미 가입한 회원입니다. uuid : " + uuid);
        }
    }
}
