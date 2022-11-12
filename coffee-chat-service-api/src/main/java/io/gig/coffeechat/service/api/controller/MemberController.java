package io.gig.coffeechat.service.api.controller;

import io.gig.coffeechat.service.api.dto.member.MemberDto;
import io.gig.coffeechat.service.api.dto.member.MemberDtoMapper;
import io.gig.coffeechat.service.api.facade.MemberFacade;
import io.gig.coffeechat.service.api.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

/**
 * @author : JAKE
 * @date : 2022/11/12
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberDtoMapper memberDtoMapper;
    private final MemberFacade memberFacade;

    @GetMapping("email-verify")
    public ResponseEntity<ApiResponse> validateDuplicateEmail(
            @NotEmpty @RequestParam("email") String email) {
        boolean validateToken = memberFacade.validateEmail(email);
        MemberDto.ValidateResponse response = memberDtoMapper.of(validateToken);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.CREATED);
    }

    @GetMapping("nickname-verify")
    public ResponseEntity<ApiResponse> validateDuplicateNickname(
            @NotEmpty @RequestParam("nickname") String nickname) {
        boolean validateToken = memberFacade.validateNickname(nickname);
        MemberDto.ValidateResponse response = memberDtoMapper.of(validateToken);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.CREATED);
    }

}
