package io.gig.coffeechat.domain.member.mentee;

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
public class MenteeSignUpService implements SignUpService {

    private final MemberStore memberStore;

    @Override
    public String signUp(String uuid, MemberCommand.SignUp signUpInfo) {
        MenteeDetail menteeDetail = MenteeDetail.createMenteeDetail(signUpInfo.getMenteeDetailInfo());
        menteeDetail.validateYear(signUpInfo.getMenteeDetailInfo().getYear());
        Member newMentee = Member.MenteeSignUp(uuid, signUpInfo, menteeDetail);
        Member savedMentee = memberStore.store(newMentee);
        return savedMentee.getUuid();
    }
}
