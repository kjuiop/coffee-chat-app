package io.gig.coffeechat.domain.member.mentor;

import io.gig.coffeechat.domain.member.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Service
@RequiredArgsConstructor
public class MentorSignUpService implements SignUpService {

    private final MemberReader memberReader;
    private final MemberStore memberStore;

    @Override
    public String signUp(String uuid, MemberCommand.SignUp signUpInfo) {
        validateDuplicateUuid(uuid);
        MentorDetail mentorDetail = MentorDetail.createMentorDetail(signUpInfo.getMentorDetailInfo());
        mentorDetail.validateYear(signUpInfo.getMentorDetailInfo().getYear());
        Member newMentor = Member.MentorSignUp(uuid, signUpInfo, mentorDetail);
        Member savedMentor = memberStore.store(newMentor);
        return savedMentor.getUuid();
    }

    private void validateDuplicateUuid(String uuid) {
        boolean isExistUuid = memberReader.isExistUuId(uuid);
        if (isExistUuid) {
            throw new InvalidParameterException("이미 존재하는 회원입니다. uuid : " + uuid);
        }
    }
}
