package io.gig.coffeechat.domain.member.repository;

import io.gig.coffeechat.domain.exception.NotFoundException;
import io.gig.coffeechat.domain.member.Member;
import io.gig.coffeechat.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Slf4j
@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryImpl implements MemberReader {

    private final MemberQueryRepository memberQueryRepository;

    @Override
    public List<Member> findAllByMemberIdsIn(List<Long> memberIds) {
        if (memberIds.isEmpty())  {
            return List.of();
        }

        return memberQueryRepository.findAllByIdIn(memberIds);
    }

    @Override
    public Member getMember(String uuid) {
        Optional<Member> findMember = memberQueryRepository.findByUuid(uuid);
        if (findMember.isEmpty()) {
            throw new NotFoundException("존재하지 않는 회원입니다. uuid : " + uuid);
        }

        return findMember.get();
    }

    @Override
    public boolean isExistUuId(String uuid) {
        return memberQueryRepository.existsByUuid(uuid);
    }

    @Override
    public boolean isExistEmail(String email) {
        return memberQueryRepository.existsByEmail(email);
    }

    @Override
    public boolean isExistNickname(String nickname) {
        return memberQueryRepository.existsByNickname(nickname);
    }
}
