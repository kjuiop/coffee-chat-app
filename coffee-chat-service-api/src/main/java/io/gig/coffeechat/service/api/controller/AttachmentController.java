package io.gig.coffeechat.service.api.controller;

import io.gig.coffeechat.domain.attachment.AttachmentCommand;
import io.gig.coffeechat.domain.attachment.AttachmentInfo;
import io.gig.coffeechat.service.api.dto.attachment.AttachmentDto;
import io.gig.coffeechat.service.api.dto.attachment.AttachmentDtoMapper;
import io.gig.coffeechat.service.api.facade.AttachmentFacade;
import io.gig.coffeechat.service.api.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : JAKE
 * @date : 2022/12/12
 */
@RestController
@RequestMapping("attachment")
@RequiredArgsConstructor
public class AttachmentController {

    private final AttachmentFacade attachmentFacade;
    private final AttachmentDtoMapper attachmentDtoMapper;

    @PostMapping("upload")
    @ResponseBody
    public ResponseEntity<ApiResponse> upload(
            @RequestParam(value = "file") MultipartFile multipartFile,
            @RequestParam(value = "usageType") String usageType,
            @RequestParam(value = "uuid") String uuid
            ) {

        AttachmentDto.Request request = AttachmentDto.Request.builder()
                .multipartFile(multipartFile)
                .usageType(usageType)
                .uuid(uuid)
                .build();

        AttachmentCommand.Upload command = attachmentDtoMapper.of(request);
        AttachmentInfo.Main result = attachmentFacade.upload(command);
        AttachmentDto.Response response = attachmentDtoMapper.of(result);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.OK);
    }

}
