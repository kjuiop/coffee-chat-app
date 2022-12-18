package io.gig.coffeechat.service.api.facade;

import io.gig.coffeechat.domain.attachment.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author : JAKE
 * @date : 2022/12/13
 */
@Service
@RequiredArgsConstructor
public class AttachmentFacade {

    private final UploadServiceFactory uploadServiceFactory;
    private final AttachmentServiceImpl attachmentServiceImpl;

    public AttachmentInfo.Main upload(AttachmentCommand.Upload request) {
        UploadService uploadService = uploadServiceFactory.create(request.getFileType());
        AttachmentInfo.Main result = uploadService.upload(request);
        attachmentServiceImpl.create(result);
        return result;
    }

}
