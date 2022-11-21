package io.gig.coffeechat.domain.role.repository;

import io.gig.coffeechat.domain.role.RoleReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    public boolean isExistByName(String name) {
        return roleQueryRepository.existsByName(name);
    }

    @Override
    public boolean isExistRole() {
        return roleQueryRepository.count() > 0;
    }
}
