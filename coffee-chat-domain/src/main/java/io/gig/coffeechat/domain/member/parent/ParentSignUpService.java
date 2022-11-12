package io.gig.coffeechat.domain.member.parent;

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
public class ParentSignUpService implements SignUpService {

    private final MemberReader memberReader;
    private final MemberStore memberStore;

    @Override
    public String signUp(String uuid, MemberCommand.SignUp signUpInfo) {
        validateSignUp(uuid, signUpInfo.getEmail(), signUpInfo.getNickname());
        ParentDetail parentDetail = ParentDetail.createParentDetail(signUpInfo.getParentDetailInfo());
        parentDetail.validateYear(signUpInfo.getParentDetailInfo().getYear());
        Member newParent = Member.ParentSignUp(uuid, signUpInfo, parentDetail);
        Member savedParent = memberStore.store(newParent);
        return savedParent.getUuid();
    }

    private void validateSignUp(String uuid, String email, String nickname) {
        validateDuplicateUuid(uuid);
        validateDuplicateEmail(email);
        validateDuplicateNickname(nickname);
    }

    private void validateDuplicateUuid(String uuid) {
        boolean isExistUuid = memberReader.isExistUuId(uuid);
        if (isExistUuid) {
            throw new InvalidParameterException("이미 존재하는 회원입니다. uuid : " + uuid);
        }
    }

    private void validateDuplicateEmail(String email) {
        boolean isExistEmail = memberReader.isExistEmail(email);
        if (isExistEmail) {
            throw new InvalidParameterException("이미 존재하는 이메일입니다. email : " + email);
        }
    }

    private void validateDuplicateNickname(String nickname) {
        boolean isExistNickname = memberReader.isExistNickname(nickname);
        if (isExistNickname) {
            throw new InvalidParameterException("이미 존재하는 닉네임입니다. nickname : " + nickname);
        }
    }
}
