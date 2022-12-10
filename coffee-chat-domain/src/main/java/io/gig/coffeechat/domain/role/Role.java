package io.gig.coffeechat.domain.role;

import io.gig.coffeechat.domain.common.BaseTimeEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author : JAKE
 * @date : 2022/11/20
 */
@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Role extends BaseTimeEntity {

    private final String prefix = "ROLE_";

    @Id
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Builder.Default
    private int sortOrder = 0;

    public static Role createRole(String name, String description, int sortOrder) {
        return Role.builder()
                .name(name)
                .description(description)
                .sortOrder(sortOrder)
                .build();
    }
}
