package io.gig.coffeechat.domain.member.parent.repository;

import io.gig.coffeechat.domain.member.parent.ParentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : JAKE
 * @date : 2022/12/24
 */
@Repository
public interface ParentStoreRepository extends JpaRepository<ParentDetail, Long> {
}
