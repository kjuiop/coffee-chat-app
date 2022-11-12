package io.gig.coffeechat.domain.member.repository;

import io.gig.coffeechat.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MemberQueryImpl implements MemberReader {

    private final MemberQueryRepository memberQueryRepository;

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
