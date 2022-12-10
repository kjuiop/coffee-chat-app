package io.gig.coffeechat.domain.role.repository;

import io.gig.coffeechat.domain.exception.NotFoundException;
import io.gig.coffeechat.domain.role.Role;
import io.gig.coffeechat.domain.role.RoleReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author : JAKE
 * @date : 2022/11/21
 */
@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoleQueryImpl implements RoleReader {

    private final RoleQueryRepository roleQueryRepository;

    @Override
    public Role findByRoleName(String roleName) {
        Optional<Role> findByRole = roleQueryRepository.findByName(roleName);
        if (findByRole.isEmpty()) {
            throw new NotFoundException("해당 권한은 존재하지 않습니다. role name : " + roleName);
        }

        return findByRole.get();
    }

    @Override
    public boolean isExistByName(String name) {
        return roleQueryRepository.existsByName(name);
    }

    @Override
    public boolean isExistRole() {
        return roleQueryRepository.count() > 0;
    }
}
