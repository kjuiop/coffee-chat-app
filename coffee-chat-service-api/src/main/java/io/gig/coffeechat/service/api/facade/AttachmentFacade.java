package io.gig.coffeechat.service.api.facade;

import io.gig.coffeechat.domain.attachment.AttachmentCommand;
import io.gig.coffeechat.domain.attachment.AttachmentInfo;
import io.gig.coffeechat.domain.attachment.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : JAKE
 * @date : 2022/12/13
 */
@Service
@RequiredArgsConstructor
public class AttachmentFacade {

    private final AttachmentService attachmentService;

    public AttachmentInfo.Main upload(AttachmentCommand.Upload request) {
        return attachmentService.upload(request);
    }


}
