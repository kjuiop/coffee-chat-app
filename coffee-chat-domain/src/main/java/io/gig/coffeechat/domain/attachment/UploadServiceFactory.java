package io.gig.coffeechat.domain.attachment;

import io.gig.coffeechat.domain.attachment.types.FileType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : JAKE
 * @date : 2022/12/13
 */
@Component
@RequiredArgsConstructor
public class UploadServiceFactory {

    private final ImageUploadService imageUploadService;

    public UploadService create(FileType fileType) {

        switch (fileType) {
            case Image:
                return imageUploadService;
            case Document:
                return null;
        }

        return null;
    }
}
