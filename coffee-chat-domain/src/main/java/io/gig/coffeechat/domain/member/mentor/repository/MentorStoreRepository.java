package io.gig.coffeechat.domain.member.mentor.repository;

import io.gig.coffeechat.domain.member.mentor.MentorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : JAKE
 * @date : 2022/12/22
 */
@Repository
public interface MentorStoreRepository extends JpaRepository<MentorDetail, Long> {
}
