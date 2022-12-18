package io.gig.coffeechat.domain.member;

import io.gig.coffeechat.domain.exception.AlreadyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : JAKE
 * @date : 2022/11/12
 */
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberReader memberReader;
    private final MemberStore memberStore;

    @Override
    @Transactional(readOnly = true)
    public List<MemberInfo.Main> getMembers(List<Long> memberIds) {
        List<Member> members = memberReader.findAllByMemberIdsIn(memberIds);
        return members.stream()
                .map(member -> new MemberInfo.Main(member.getId(), member.getUuid(), member.getNickname())).
                collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public MemberInfo.Main getMember(String uuid) {
        Member findMember = memberReader.getMember(uuid);
        return new MemberInfo.Main(findMember.getId(), findMember.getUuid(), findMember.getNickname());
    }

    @Override
    @Transactional
    public boolean changeNickname(String uuid, MemberCommand.ChangeNickname request) {
        boolean isValid = validateNickname(request.getNickname());
        if (!isValid) {
            return false;
        }
        Member findMember = memberReader.getMember(uuid);
        findMember.changeNickname(request.getNickname());
        memberStore.store(findMember);
        return true;
    }

    @Override
    @Transactional
    public boolean changeProfileImage(String uuid, MemberCommand.ChangeProfileImage request) {
        Member findMember = memberReader.getMember(uuid);
        findMember.changeProfileImage(request.getProfileImageUrl());
        memberStore.store(findMember);
        return true;
    }

    @Override
    public boolean changeMarketingApprove(String uuid, MemberCommand.ChangeMarketingApprove request) {
        Member findMember = memberReader.getMember(uuid);
        findMember.changeMarketingApprove(request.getMarketingAgreeYn());
        memberStore.store(findMember);
        return true;
    }

    @Override
    @Transactional
    public boolean login(MemberCommand.SignIn request) {
        Member findMember = memberReader.getMember(request.getUuid());
        findMember.login();
        memberStore.store(findMember);
        return true;
    }

    @Override
    @Transactional
    public void authMemberEmailValidate(String uuid) {
        validateCheckMember(uuid);
        Member findMember = memberReader.getMember(uuid);
        findMember.isValidEmail();
        memberStore.store(findMember);
    }

    private void validateCheckMember(String uuid) {
        boolean isExistUuid = memberReader.isExistUuId(uuid);
        if (!isExistUuid) {
            throw new InvalidParameterException("존재하지 않는 회원입니다. uuid : " + uuid);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public boolean validateEmail(String email) {
        boolean isExistEmail = memberReader.isExistEmail(email);
        if (isExistEmail) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean validateNickname(String nickname) {
        boolean isExistNickname = memberReader.isExistNickname(nickname);
        if (isExistNickname) {
            return false;
        }
        return true;
    }
}
