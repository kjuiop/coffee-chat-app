package io.gig.coffeechat.service.api.controller;

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

    @PostMapping("upload")
    @ResponseBody
    public ResponseEntity<ApiResponse> upload(
            @RequestParam(value = "file") MultipartFile multipartFile,
            @RequestParam(value = "usageType") String usageType) {

        return new ResponseEntity<>(ApiResponse.OK(), HttpStatus.OK);
    }

}
