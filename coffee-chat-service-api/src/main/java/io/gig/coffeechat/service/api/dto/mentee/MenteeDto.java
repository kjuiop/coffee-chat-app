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
    @Builder
    public static class Response {
        private final Boolean isOk;
    }

}
