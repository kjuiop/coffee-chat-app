package io.gig.coffeechat.domain.follow;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : JAKE
 * @date : 2022/11/19
 */

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final FollowStore followStore;

    @Override
    @Transactional
    public void create(FollowCommand.FromFollow fromMember, FollowCommand.ToFollow toMember) {
        Follow newFollow = Follow.CreateFollow(fromMember, toMember);
        followStore.store(newFollow);
    }
}
