package io.gig.coffeechat.domain.attachment;

import lombok.Builder;
import lombok.Getter;

/**
 * @author : JAKE
 * @date : 2022/12/13
 */
public class AttachmentInfo {

    @Getter
    @Builder
    public static class Main {
        private String fileType;
        private String originalFilename;
        private String savedFilename;
        private String fullPath;

        public Main(String fileType, String originalFilename, String savedFilename, String fullPath) {
            this.fileType = fileType;
            this.originalFilename = originalFilename;
            this.savedFilename = savedFilename;
            this.fullPath = fullPath;
        }
    }

}
