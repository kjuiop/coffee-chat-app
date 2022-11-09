package io.gig.coffeechat.domain.member.mentee;

import io.gig.coffeechat.domain.member.types.GenderType;
import io.gig.coffeechat.domain.member.types.StudentType;
import io.gig.coffeechat.domain.member.types.UsageAuthorityType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
public class MenteeCommand {

    @Getter
    @Builder
    public static class SignUp {
        private final String email;
        private final String nickname;
        private final LocalDate birth;
        private final GenderType gender;
        private final UsageAuthorityType usageAuthority;
        private final MenteeDetailInfo menteeDetailInfo;
    }


    @Getter
    @Builder
    public static class MenteeDetailInfo {
        private final StudentType studentType;
        private final Integer year;
        private final String schoolName;
    }

}
