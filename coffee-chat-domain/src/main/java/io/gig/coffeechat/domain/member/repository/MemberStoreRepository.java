package io.gig.coffeechat.domain.member.repository;

import io.gig.coffeechat.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Repository
public interface MemberStoreRepository extends JpaRepository<Member, Long> {
}
