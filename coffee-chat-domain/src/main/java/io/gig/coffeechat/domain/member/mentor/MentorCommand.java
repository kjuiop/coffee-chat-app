package io.gig.coffeechat.domain.member.mentor;

import lombok.Builder;
import lombok.Getter;

/**
 * @author : JAKE
 * @date : 2022/12/22
 */
public class MentorCommand {

    @Getter
    @Builder
    public static class ChangeUniversity {
        private final String university;
    }

    @Getter
    @Builder
    public static class ChangeYear {
        private final Integer year;
    }

}
