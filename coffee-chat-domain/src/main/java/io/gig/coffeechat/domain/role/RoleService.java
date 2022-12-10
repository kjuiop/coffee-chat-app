package io.gig.coffeechat.domain.role;

/**
 * @author : JAKE
 * @date : 2022/11/21
 */
public interface RoleService {

    boolean isExistRole();

    void initRole(String name, String description, int sortOrder);
}
