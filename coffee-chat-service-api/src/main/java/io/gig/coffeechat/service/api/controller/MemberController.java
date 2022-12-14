package io.gig.coffeechat.service.api.controller;

import io.gig.coffeechat.domain.member.MemberCommand;
import io.gig.coffeechat.service.api.dto.member.MemberDto;
import io.gig.coffeechat.service.api.dto.member.MemberDtoMapper;
import io.gig.coffeechat.service.api.facade.MemberFacade;
import io.gig.coffeechat.service.api.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("members/{uuid}/profile-image")
    @ResponseBody
    public ResponseEntity<ApiResponse> changeProfileImage(
            @PathVariable String uuid,
            @RequestBody @Valid MemberDto.ChangeProfileImageRequest request
    ) {
        MemberCommand.ChangeProfileImage memberCommand = memberDtoMapper.of(request);
        boolean result = memberFacade.changeProfileImage(uuid, memberCommand);
        MemberDto.ValidateResponse response = memberDtoMapper.of(result);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.OK);
    }

    @PutMapping("members/{uuid}/nickname")
    @ResponseBody
    public ResponseEntity<ApiResponse> changeNickname(
            @PathVariable String uuid,
            @RequestBody @Valid MemberDto.ChangeNicknameRequest request
            ) {
        MemberCommand.ChangeNickname memberCommand = memberDtoMapper.of(request);
        boolean result = memberFacade.changeNickname(uuid, memberCommand);
        MemberDto.ValidateResponse response = memberDtoMapper.of(result);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.OK);
    }

    @PutMapping("members/{uuid}/marketing-approve")
    @ResponseBody
    public ResponseEntity<ApiResponse> changeMarketingApprove(
            @PathVariable String uuid,
            @RequestBody @Valid MemberDto.ChangeMarketingApproveRequest request
    ) {
        MemberCommand.ChangeMarketingApprove memberCommand = memberDtoMapper.of(request);
        boolean result = memberFacade.changeMarketingApprove(uuid, memberCommand);
        MemberDto.ValidateResponse response = memberDtoMapper.of(result);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.OK);
    }

    @PostMapping("members/{uuid}/email-auth")
    @ResponseBody
    public ResponseEntity<ApiResponse> authEmailValidateCode(
            @PathVariable String uuid) {
        memberFacade.authMemberEmailValidate(uuid);
        return new ResponseEntity<>(ApiResponse.OK(), HttpStatus.OK);
    }

    @GetMapping("email-verify")
    public ResponseEntity<ApiResponse> validateDuplicateEmail(
            @NotEmpty @RequestParam("email") String email) {
        boolean validateToken = memberFacade.validateEmail(email);
        MemberDto.ValidateResponse response = memberDtoMapper.of(validateToken);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.OK);
    }

    @GetMapping("nickname-verify")
    public ResponseEntity<ApiResponse> validateDuplicateNickname(
            @NotEmpty @RequestParam("nickname") String nickname) {
        boolean validateToken = memberFacade.validateNickname(nickname);
        MemberDto.ValidateResponse response = memberDtoMapper.of(validateToken);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.OK);
    }

}
