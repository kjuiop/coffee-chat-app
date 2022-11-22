package io.gig.coffeechat.domain.role.repository;

import io.gig.coffeechat.domain.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : JAKE
 * @date : 2022/11/21
 */
@Repository
public interface RoleStoreRepository extends JpaRepository<Role, String> {
}
