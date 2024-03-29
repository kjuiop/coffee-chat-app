package io.gig.coffeechat.domain.member.mentee;

import io.gig.coffeechat.domain.member.*;
import io.gig.coffeechat.domain.member.memberRole.MemberRole;
import io.gig.coffeechat.domain.role.Role;
import io.gig.coffeechat.domain.role.RoleReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Service
@RequiredArgsConstructor
public class MenteeSignUpService implements SignUpService {

    private final MemberReader memberReader;
    private final MemberStore memberStore;

    private final RoleReader roleReader;

    @Override
    @Transactional
    public MemberInfo.Main signUp(String uuid, MemberCommand.SignUp signUpInfo) {
        validateSignUp(uuid, signUpInfo.getEmail(), signUpInfo.getNickname());

        MenteeDetail menteeDetail = MenteeDetail.createMenteeDetail(signUpInfo.getMenteeDetailInfo());
        menteeDetail.validateYear(signUpInfo.getMenteeDetailInfo().getYear());

        Member newMentee = Member.MenteeSignUp(uuid, signUpInfo, menteeDetail);
        newMentee.validateNickname(newMentee.getNickname());

        Role userRole = roleReader.findByRoleName("ROLE_USER");
        MemberRole newRole = MemberRole.addMemberRole(newMentee, userRole);
        newMentee.addRole(newRole);

        Member savedMentee = memberStore.store(newMentee);
        return new MemberInfo.Main(savedMentee);
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
