package io.gig.coffeechat.domain.member.mentor;

import io.gig.coffeechat.domain.member.types.GenderType;
import io.gig.coffeechat.domain.member.types.UsageAuthorityType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
public class MentorCommand {

    @Getter
    @Builder
    public static class SignUp {
        private final String email;
        private final String nickname;
        private final LocalDate birth;
        private final GenderType gender;
        private final UsageAuthorityType usageAuthority;
        private final MentorCommand.MentorDetailInfo mentorDetailInfo;
    }

    @Getter
    @Builder
    public static class MentorDetailInfo {
        private final String schoolName;
        private final Integer year;
        private final String studentNo;
        private final String major;
    }

}