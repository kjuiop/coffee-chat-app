package io.gig.coffeechat.domain.follow.repository;

import io.gig.coffeechat.domain.follow.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : JAKE
 * @date : 2022/11/19
 */
@Repository
public interface FollowStoreRepository extends JpaRepository<Follow, Long> {
}
