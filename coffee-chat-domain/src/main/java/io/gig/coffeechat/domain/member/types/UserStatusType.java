package io.gig.coffeechat.domain.member.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : JAKE
 * @date : 2022/11/12
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UserStatusType {

    PENDING("Pending", "보류"),

    NORMAL("Normal", "정상"),

    WITHDRAW("Withdraw", "탈퇴"),

    INACTIVE("InActive", "비활성화");

    private String key;

    private String description;

}
