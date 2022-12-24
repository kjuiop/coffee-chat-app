package io.gig.coffeechat.domain.member.mentor.repository;

import io.gig.coffeechat.domain.member.mentor.MentorDetail;
import io.gig.coffeechat.domain.member.mentor.MentorStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : JAKE
 * @date : 2022/12/22
 */
@Component
@RequiredArgsConstructor
public class MentorStoreImpl implements MentorStore {

    private final MentorStoreRepository mentorStoreRepository;

    @Override
    public MentorDetail store(MentorDetail mentorDetail) {
        return mentorStoreRepository.save(mentorDetail);
    }
}
