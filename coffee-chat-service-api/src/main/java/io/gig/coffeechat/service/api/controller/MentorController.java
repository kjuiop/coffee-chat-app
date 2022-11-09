package io.gig.coffeechat.service.api.controller;

import io.gig.coffeechat.domain.member.mentor.MentorCommand;
import io.gig.coffeechat.service.api.dto.mentor.MentorDto;
import io.gig.coffeechat.service.api.dto.mentor.MentorDtoMapper;
import io.gig.coffeechat.service.api.facade.MentorFacade;
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
@RequestMapping("members/mentors")
@RequiredArgsConstructor
public class MentorController {

    private final MentorDtoMapper mentorDtoMapper;
    private final MentorFacade mentorFacade;

    @PostMapping("{uuid}/sign-up")
    @ResponseBody
    public ResponseEntity<ApiResponse> mentorSignUp(
            @PathVariable(name = "uuid") String uuid,
            @RequestBody @Valid MentorDto.SignUpRequest request) {
        MentorCommand.SignUp mentorCommand = mentorDtoMapper.of(request);
        String signUpToken = mentorFacade.signUp(uuid, mentorCommand);
        MentorDto.SignUpResponse response = mentorDtoMapper.of(signUpToken);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.CREATED);
    }

}
