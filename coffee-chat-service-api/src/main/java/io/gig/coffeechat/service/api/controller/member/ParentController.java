package io.gig.coffeechat.service.api.controller.member;

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
@RequestMapping("members/parents")
@RequiredArgsConstructor
public class ParentController {

    @PostMapping("{uuid}/sign-up")
    @ResponseBody
    public ResponseEntity<ApiResponse> parentSignUp(
            @PathVariable(name = "uuid") String uuid) {
        return new ResponseEntity<>(ApiResponse.OK(uuid), HttpStatus.CREATED);
    }

}
