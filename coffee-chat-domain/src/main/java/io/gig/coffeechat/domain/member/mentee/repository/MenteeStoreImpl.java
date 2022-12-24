package io.gig.coffeechat.domain.member.mentee.repository;

import io.gig.coffeechat.domain.member.mentee.MenteeDetail;
import io.gig.coffeechat.domain.member.mentee.MenteeStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : JAKE
 * @date : 2022/12/24
 */
@Component
@Transactional
@RequiredArgsConstructor
public class MenteeStoreImpl implements MenteeStore {

    private final MenteeStoreRepository menteeStoreRepository;

    @Override
    public MenteeDetail store(MenteeDetail menteeDetail) {
        return menteeStoreRepository.save(menteeDetail);
    }
}
