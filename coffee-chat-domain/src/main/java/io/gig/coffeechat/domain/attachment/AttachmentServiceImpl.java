package io.gig.coffeechat.domain.attachment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : JAKE
 * @date : 2022/12/13
 */
@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentStore attachmentStore;

    @Override
    @Transactional
    public void create(AttachmentInfo.Main result) {
        Attachment newAttachment = Attachment.Of(result.getUsageType(), result.getFileType(), result.getUuid(),
                result.getOriginalFilename(), result.getSavedFilename(), result.getFullPath());

        attachmentStore.store(newAttachment);
    }

}
