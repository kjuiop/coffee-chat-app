package io.gig.coffeechat.domain.role.repository;

import io.gig.coffeechat.domain.role.Role;
import io.gig.coffeechat.domain.role.RoleStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : JAKE
 * @date : 2022/11/21
 */
@Component
@Transactional
@RequiredArgsConstructor
public class RoleStoreImpl implements RoleStore {

    private final RoleStoreRepository roleStoreRepository;

    @Override
    public Role store(Role role) {
        return roleStoreRepository.save(role);
    }
}
