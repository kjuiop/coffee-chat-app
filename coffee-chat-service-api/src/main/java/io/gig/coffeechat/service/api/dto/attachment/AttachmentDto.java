package io.gig.coffeechat.service.api.dto.attachment;

import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : JAKE
 * @date : 2022/12/13
 */
public class AttachmentDto {

    @Getter
    @Builder
    public static class Request {
        private MultipartFile multipartFile;
        private String usageType;
        private String fileType;
        private String uuid;
    }

    @Getter
    @Builder
    public static class Response {
        private String fileType;
        private String originalFilename;
        private String savedFilename;
        private String fullPath;
    }

}
