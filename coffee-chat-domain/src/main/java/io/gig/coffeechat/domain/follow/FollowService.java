package io.gig.coffeechat.domain.follow;

/**
 * @author : JAKE
 * @date : 2022/11/19
 */
public interface FollowService {

    void create(FollowCommand.FromFollow fromMember, FollowCommand.ToFollow toMember);

}
