package io.gig.coffeechat.domain.follow.repository;

import io.gig.coffeechat.domain.follow.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : JAKE
 * @date : 2022/11/20
 */
@Repository
public interface FollowQueryRepository extends JpaRepository<Follow, Long> {

    List<Follow> findAllByFromMemberId(Long memberId);
}
