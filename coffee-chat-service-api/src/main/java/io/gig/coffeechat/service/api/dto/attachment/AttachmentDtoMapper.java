package io.gig.coffeechat.service.api.dto.attachment;

import io.gig.coffeechat.domain.attachment.AttachmentCommand;
import io.gig.coffeechat.domain.attachment.AttachmentInfo;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author : JAKE
 * @date : 2022/12/13
 */
@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface AttachmentDtoMapper {

    AttachmentCommand.Upload of(AttachmentDto.Request request);

    AttachmentDto.Response of(AttachmentInfo.Main attachmentInfo);
}
