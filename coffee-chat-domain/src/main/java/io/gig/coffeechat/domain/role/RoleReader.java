package io.gig.coffeechat.domain.role;

/**
 * @author : JAKE
 * @date : 2022/11/21
 */
public interface RoleReader {

    boolean isExistRole();

    boolean isExistByName(String name);

    Role findByRoleName(String role_user);
}
