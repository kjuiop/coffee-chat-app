package io.gig.coffeechat.domain.follow.repository;

import io.gig.coffeechat.domain.follow.Follow;
import io.gig.coffeechat.domain.follow.FollowReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : JAKE
 * @date : 2022/11/20
 */
@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FollowQueryImpl implements FollowReader {

    private final FollowQueryRepository followQueryRepository;

    @Override
    public List<Follow> getFollowingList(Long memberId) {
        return followQueryRepository.findAllByFromMemberId(memberId);
    }
}
