package io.gig.coffeechat.domain.attachment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : JAKE
 * @date : 2022/12/13
 */
@Service
@RequiredArgsConstructor
public class ImageUploadService implements UploadService {

    @Override
    public AttachmentInfo.Main upload(AttachmentCommand.Upload request) {
        return null;
    }
}
