package io.gig.coffeechat.domain.follow.repository;

import io.gig.coffeechat.domain.follow.Follow;
import io.gig.coffeechat.domain.follow.FollowStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : JAKE
 * @date : 2022/11/19
 */
@Component
@Transactional
@RequiredArgsConstructor
public class FollowStoreImpl implements FollowStore {

    private final FollowStoreRepository followStoreRepository;

    @Override
    public Follow store(Follow follow) {
        return followStoreRepository.save(follow);
    }
}
