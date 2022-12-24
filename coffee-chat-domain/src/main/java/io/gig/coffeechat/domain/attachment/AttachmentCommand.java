package io.gig.coffeechat.domain.attachment;

import io.gig.coffeechat.domain.attachment.types.FileType;
import io.gig.coffeechat.domain.attachment.types.UsageType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : JAKE
 * @date : 2022/12/13
 */
public class AttachmentCommand {

    @Getter
    @Builder
    public static class Upload {
        private MultipartFile multipartFile;
        private UsageType usageType;
        private String uuid;
        private FileType fileType;
    }
}
