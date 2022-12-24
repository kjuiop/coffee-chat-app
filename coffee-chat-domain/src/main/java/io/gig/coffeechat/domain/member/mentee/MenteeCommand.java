package io.gig.coffeechat.domain.member.mentee;

import lombok.Builder;
import lombok.Getter;

/**
 * @author : JAKE
 * @date : 2022/12/24
 */
public class MenteeCommand {

    @Getter
    @Builder
    public static class ChangeSchoolName {
        private final String schoolName;
    }
}
