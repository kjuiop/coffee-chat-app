package io.gig.coffeechat.domain.member;

import io.gig.coffeechat.domain.member.mentee.MenteeCommand;
import io.gig.coffeechat.domain.member.mentee.MenteeDetail;
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


}
