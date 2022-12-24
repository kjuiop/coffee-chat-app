package io.gig.coffeechat.domain.member.parent;

import lombok.Builder;
import lombok.Getter;

/**
 * @author : JAKE
 * @date : 2022/12/24
 */
public class ParentCommand {

    @Getter
    @Builder
    public static class ChangeSchoolName {
        private final String schoolName;
    }

    @Getter
    @Builder
    public static class ChangeYear {
        private final Integer year;
    }

}
