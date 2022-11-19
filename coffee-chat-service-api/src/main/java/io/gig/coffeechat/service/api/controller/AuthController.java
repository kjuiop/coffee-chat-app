package io.gig.coffeechat.service.api.controller;

import io.gig.coffeechat.domain.member.MemberCommand;
import io.gig.coffeechat.service.api.dto.member.*;
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
public class AuthController {

    private final SignUpDtoMapper signUpDtoMapper;
    private final SignInDtoMapper signInDtoMapper;
    private final MemberDtoMapper memberDtoMapper;
    private final MemberFacade memberFacade;

    @PostMapping("sign-up/{uuid}")
    @ResponseBody
    public ResponseEntity<ApiResponse> signUp(
            @PathVariable(name = "uuid") String uuid,
            @RequestBody @Valid SignUpDto.SignUp request) {
        MemberCommand.SignUp memberCommand = signUpDtoMapper.of(request);
        String signUpToken = memberFacade.signUp(uuid, memberCommand);
        SignUpDto.SignUpResponse response = signUpDtoMapper.of(signUpToken);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.CREATED);
    }


    @PostMapping("login")
    @ResponseBody
    public ResponseEntity<ApiResponse> login(
            @RequestBody @Valid SignInDto.SignIn request
    ) {
        MemberCommand.SignIn memberCommand = signInDtoMapper.of(request);
        boolean validateToken = memberFacade.login(memberCommand);
        MemberDto.ValidateResponse response = memberDtoMapper.of(validateToken);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.OK);
    }
}
