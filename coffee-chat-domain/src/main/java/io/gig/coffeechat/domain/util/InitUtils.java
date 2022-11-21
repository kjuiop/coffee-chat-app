package io.gig.coffeechat.domain.util;

import io.gig.coffeechat.domain.exception.AlreadyEntity;
import io.gig.coffeechat.domain.role.RoleReader;
import io.gig.coffeechat.domain.role.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : JAKE
 * @date : 2022/11/20
 */
@Component
@RequiredArgsConstructor
public class InitUtils {

    private final RoleService roleService;

    @Transactional(rollbackFor = {AlreadyEntity.class})
    public void initData() {

        validationAlreadyEntity();

        roleService.initRole("ROLE_SUPER_ADMIN", "슈퍼관리자", 0);
        roleService.initRole("ROLE_ADMIN", "관리자", 1);
        roleService.initRole("ROLE_USER", "사용자", 2);
        roleService.initRole("ROLE_ANONYMOUS", "익명사용자", 3);
    }

    private void validationAlreadyEntity() {
        boolean isExistData = roleService.isExistRole();
        if (isExistData) {
            throw new AlreadyEntity(">>> Already Exist Data");
        }
    }

}
