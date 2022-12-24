package io.gig.coffeechat.service.api.dto.mentee;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : JAKE
 * @date : 2022/12/24
 */
public class MenteeDto {

    @Getter
    @NoArgsConstructor
    public static class ChangeSchoolNameRequest {
        private String schoolName;
    }

    @Getter
    @NoArgsConstructor
    public static class ChangeYearRequest {
        private Integer year;
    }

    @Getter
    @Builder
    public static class Response {
        private final Boolean isOk;
    }

}
