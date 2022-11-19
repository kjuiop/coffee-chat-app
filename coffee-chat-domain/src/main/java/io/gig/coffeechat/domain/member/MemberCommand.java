package io.gig.coffeechat.domain.member;

import io.gig.coffeechat.domain.common.YnType;
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
public class MemberCommand {

    @Getter
    @Builder
    public static class SignUp {
        private final String email;
        private final String nickname;
        private final LocalDate birth;
        private final GenderType gender;
        private final UsageAuthorityType usageAuthority;
        private final YnType marketingAgreeYn;
        private final MenteeDetailInfo menteeDetailInfo;
        private final MentorDetailInfo mentorDetailInfo;
        private final ParentDetailInfo parentDetailInfo;
    }

    @Getter
    @Builder
    public static class SignIn {
        private final String uuid;
    }

    @Getter
    @Builder
    public static class MenteeDetailInfo {
        private final StudentType studentType;
        private final Integer year;
        private final String schoolName;
    }

    @Getter
    @Builder
    public static class MentorDetailInfo {
        private final String schoolName;
        private final Integer year;
        private final String studentNo;
        private final String major;
    }

    @Getter
    @Builder
    public static class ParentDetailInfo {
        private final StudentType studentType;
        private final Integer year;
        private final String schoolName;
    }

    @Getter
    @Builder
    public static class EmailValidate {
        private String email;
    }

    @Getter
    @Builder
    public static class NicknameValidate {
        private String nickname;
    }

}
