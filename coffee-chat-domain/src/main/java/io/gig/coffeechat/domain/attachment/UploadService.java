package io.gig.coffeechat.domain.attachment;

/**
 * @author : JAKE
 * @date : 2022/12/13
 */
@FunctionalInterface
public interface UploadService {

    AttachmentInfo.Main upload(AttachmentCommand.Upload request);
}
