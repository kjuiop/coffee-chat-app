package io.gig.coffeechat.domain.member.repository;

import io.gig.coffeechat.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Repository
public interface MemberQueryRepository extends JpaRepository<Member, Long> {

    boolean existsByUuid(String uuid);

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);

    Optional<Member> findByUuid(String uuid);
}
