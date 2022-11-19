package io.gig.coffeechat.domain.follow;

import java.util.List;

/**
 * @author : JAKE
 * @date : 2022/11/20
 */
public interface FollowReader {
    List<Follow> getFollowingList(Long memberId);
}
