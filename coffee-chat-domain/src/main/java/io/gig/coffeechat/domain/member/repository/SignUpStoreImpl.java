package io.gig.coffeechat.domain.member.repository;

import io.gig.coffeechat.domain.member.Member;
import io.gig.coffeechat.domain.member.SignUpStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Component
@RequiredArgsConstructor
public class SignUpStoreImpl implements SignUpStore {

    private final SignUpRepository signUpRepository;

    @Override
    public Member store(Member member) {
        return signUpRepository.save(member);
    }

}
