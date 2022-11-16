package io.gig.coffeechat.service.api.controller;

import io.gig.coffeechat.domain.member.MemberCommand;
import io.gig.coffeechat.service.api.dto.member.SignUpDto;
import io.gig.coffeechat.service.api.dto.member.SignUpDtoMapper;
import io.gig.coffeechat.service.api.facade.MemberFacade;
import io.gig.coffeechat.service.api.util.ApiResponse;
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
@RequestMapping("members")
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpDtoMapper signUpDtoMapper;
    private final MemberFacade memberFacade;

    @PostMapping("{uuid}/sign-up")
    @ResponseBody
    public ResponseEntity<ApiResponse> signUp(
            @PathVariable(name = "uuid") String uuid,
            @RequestBody @Valid SignUpDto.SignUp request) {
        MemberCommand.SignUp parentCommand = signUpDtoMapper.of(request);
        String signUpToken = memberFacade.signUp(uuid, parentCommand);
        SignUpDto.SignUpResponse response = signUpDtoMapper.of(signUpToken);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.CREATED);
    }



}
