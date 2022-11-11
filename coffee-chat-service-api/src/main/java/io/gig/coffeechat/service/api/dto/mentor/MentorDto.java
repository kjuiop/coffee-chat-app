package io.gig.coffeechat.service.api.dto.mentor;

import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
public class MentorDto {


    @Getter
    @Builder
    public static class SignUpRequest {

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

        private DetailInfo mentorDetailInfo;
    }

    @Getter
    @Builder
    public static class DetailInfo {

        @NotBlank(message = "schoolName 은 필수값입니다.")
        private String schoolName;

        @NotNull(message = "year 은 필수값입니다.")
        private Integer year;

        @NotBlank(message = "studentNo 은 필수값입니다.")
        private String studentNo;

        @NotBlank(message = "major 은 필수값입니다.")
        private String major;
    }

    @Getter
    @Builder
    public static class SignUpResponse {
        private final String signUpToken;
    }

}
