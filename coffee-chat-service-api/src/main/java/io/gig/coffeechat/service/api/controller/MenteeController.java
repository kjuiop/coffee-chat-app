package io.gig.coffeechat.service.api.controller;

import io.gig.coffeechat.service.api.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Slf4j
@RestController
@RequestMapping("members/mentees")
@RequiredArgsConstructor
public class MenteeController {

    @PostMapping("{uuid}/sign-up")
    @ResponseBody
    public ResponseEntity<ApiResponse> menteeSignUp(
            @PathVariable(name = "uuid") String uuid) {
        return new ResponseEntity<>(ApiResponse.OK(uuid), HttpStatus.CREATED);
    }

}
