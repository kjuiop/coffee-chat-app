package io.gig.coffeechat.domain.role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author : JAKE
 * @date : 2022/11/21
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final String prefix = "ROLE_";
    private final RoleReader roleReader;
    private final RoleStore roleStore;

    @Override
    @Transactional
    public void initRole(String name, String description, int sortOrder) {
        validationRoleName(name);
        Role newRole = Role.createRole(name, description, sortOrder);
        roleStore.store(newRole);
    }

    private void validationRoleName(String name) {
        if (!StringUtils.hasText(name)) { throw new IllegalArgumentException(""); }
        if (existsRoleName(name))  { throw new RuntimeException(); }
        if (!checkedPrefixRoleName(name)) { throw new RuntimeException(); }
    }

    private boolean checkedPrefixRoleName(String name) {
        return name.toUpperCase().startsWith(prefix);
    }

    private boolean existsRoleName(String name) {
        return roleReader.isExistByName(name);
    }

    @Override
    public boolean isExistRole() {
        return roleReader.isExistRole();
    }


}
