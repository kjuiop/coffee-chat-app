package io.gig.coffeechat.service.api.controller.member;

import io.gig.coffeechat.domain.member.mentee.MenteeCommand;
import io.gig.coffeechat.service.api.dto.mentee.MenteeDto;
import io.gig.coffeechat.service.api.dto.mentee.MenteeDtoMapper;
import io.gig.coffeechat.service.api.facade.MenteeFacade;
import io.gig.coffeechat.service.api.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Slf4j
@RestController
@RequestMapping("members/mentees")
@RequiredArgsConstructor
public class MenteeController {

    private final MenteeDtoMapper menteeDtoMapper;
    private final MenteeFacade menteeFacade;

    @PostMapping("{uuid}/sign-up")
    @ResponseBody
    public ResponseEntity<ApiResponse> menteeSignUp(
            @PathVariable(name = "uuid") String uuid,
            @RequestBody @Valid MenteeDto.SignUpRequest request) {
        MenteeCommand.SignUp menteeCommand = menteeDtoMapper.of(request);
        String signUpToken = menteeFacade.signUp(uuid, menteeCommand);
        MenteeDto.SignUpResponse response = menteeDtoMapper.of(signUpToken);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.CREATED);
    }

}
