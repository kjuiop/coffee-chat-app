package io.gig.coffeechat.service.api.controller.member;

import io.gig.coffeechat.domain.member.parent.ParentCommand;
import io.gig.coffeechat.service.api.dto.parent.ParentDto;
import io.gig.coffeechat.service.api.dto.parent.ParentDtoMapper;
import io.gig.coffeechat.service.api.facade.ParentFacade;
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
@RequestMapping("members/parents")
@RequiredArgsConstructor
public class ParentController {

    private final ParentDtoMapper parentDtoMapper;
    private final ParentFacade parentFacade;

    @PostMapping("{uuid}/sign-up")
    @ResponseBody
    public ResponseEntity<ApiResponse> parentSignUp(
            @PathVariable(name = "uuid") String uuid,
            @RequestBody @Valid ParentDto.SignUpRequest request) {
        ParentCommand.SignUp parentCommand = parentDtoMapper.of(request);
        String signUpToken = parentFacade.signUp(uuid, parentCommand);
        ParentDto.SignUpResponse response = parentDtoMapper.of(signUpToken);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.CREATED);
    }

}
