package io.gig.coffeechat.domain.attachment.repository;

import io.gig.coffeechat.domain.attachment.Attachment;
import io.gig.coffeechat.domain.attachment.AttachmentStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : JAKE
 * @date : 2022/12/18
 */
@Component
@RequiredArgsConstructor
public class AttachmentStoreImpl implements AttachmentStore {

    private final AttachmentStoreRepository attachmentStoreRepository;

    @Override
    public Attachment store(Attachment attachment) {
        return attachmentStoreRepository.save(attachment);
    }
}
