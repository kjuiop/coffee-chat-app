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
    public static class ChangeHighSchool {
        private final String highSchool;
    }

    @Getter
    @Builder
    public static class ChangeYear {
        private final Integer year;
    }
}
