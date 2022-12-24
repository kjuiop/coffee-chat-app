package io.gig.coffeechat.domain.member.mentee.repository;

import io.gig.coffeechat.domain.member.mentee.MenteeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : JAKE
 * @date : 2022/12/24
 */
@Repository
public interface MenteeStoreRepository extends JpaRepository<MenteeDetail, Long> {
}
