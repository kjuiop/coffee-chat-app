package io.gig.coffeechat.service.api.dto.member;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
public class SignUpDto {

    @Getter
    @Builder
    public static class SignUp {
        @Pattern(regexp = "^[a-z0-9_+.-]+@([a-z0-9-]+\\.)+[a-z0-9]{2,4}$", message = "올바른 이메일 형식을 입력해주세요.")
        @NotBlank(message = "email 은 필수값입니다.")
        private String email;

        @NotBlank(message = "nickname 은 필수값입니다.")
        private String nickname;

        @NotNull(message = "birth 는 필수값입니다.")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private LocalDate birth;

        @NotBlank(message = "gender 는 필수값입니다.")
        private String gender;

        @NotBlank(message = "usageAuthority 는 필수값입니다.")
        private String usageAuthority;

        @NotBlank(message = "marketingAgreeYn 는 필수값입니다.")
        private String marketingAgreeYn;

        private MenteeDetailInfo menteeDetailInfo;
        private MentorDetailInfo mentorDetailInfo;
        private ParentDetailInfo parentDetailInfo;
    }

    @Getter
    @Builder
    public static class MentorDetailInfo {

        @NotBlank(message = "university 은 필수값입니다.")
        private String university;

        @NotBlank(message = "highSchool 은 필수값입니다.")
        private String highSchool;

        @NotNull(message = "year 은 필수값입니다.")
        private Integer year;

        @NotBlank(message = "studentNo 은 필수값입니다.")
        private String studentNo;

        @NotBlank(message = "major 은 필수값입니다.")
        private String major;
    }

    @Getter
    @Builder
    public static class MenteeDetailInfo {

        @NotBlank(message = "studentType 은 필수값입니다.")
        private String studentType;

        @NotBlank(message = "highSchool 은 필수값입니다.")
        private String highSchool;

        @NotNull(message = "year 은 필수값입니다.")
        private Integer year;
    }


    @Getter
    @Builder
    public static class ParentDetailInfo {

        @NotBlank(message = "studentType 은 필수값입니다.")
        private String studentType;

        @NotBlank(message = "highSchool 은 필수값입니다.")
        private String highSchool;

        @NotNull(message = "year 은 필수값입니다.")
        private Integer year;
    }


    @Getter
    @Builder
    public static class SignUpResponse {
        private final String signUpToken;
    }

}
