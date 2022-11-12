package io.gig.coffeechat.domain.member.repository;

import io.gig.coffeechat.domain.member.Member;
import io.gig.coffeechat.domain.member.MemberStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Component
@RequiredArgsConstructor
public class MemberStoreImpl implements MemberStore {

    private final MemberStoreRepository memberStoreRepository;

    @Override
    public Member store(Member member) {
        return memberStoreRepository.save(member);
    }

}
