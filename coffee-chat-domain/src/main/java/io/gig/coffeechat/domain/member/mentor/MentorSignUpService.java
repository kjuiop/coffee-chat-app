package io.gig.coffeechat.domain.member.mentor;

import io.gig.coffeechat.domain.member.Member;
import io.gig.coffeechat.domain.member.MemberCommand;
import io.gig.coffeechat.domain.member.MemberStore;
import io.gig.coffeechat.domain.member.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Service
@RequiredArgsConstructor
public class MentorSignUpService implements SignUpService {

    private final MemberStore memberStore;

    @Override
    public String signUp(String uuid, MemberCommand.SignUp signUpInfo) {
        MentorDetail mentorDetail = MentorDetail.createMentorDetail(signUpInfo.getMentorDetailInfo());
        mentorDetail.validateYear(signUpInfo.getMentorDetailInfo().getYear());
        Member newMentor = Member.MentorSignUp(uuid, signUpInfo, mentorDetail);
        Member savedMentor = memberStore.store(newMentor);
        return savedMentor.getUuid();
    }
}
