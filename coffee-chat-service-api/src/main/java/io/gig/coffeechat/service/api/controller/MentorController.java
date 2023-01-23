package io.gig.coffeechat.service.api.controller;

import io.gig.coffeechat.domain.member.MemberCommand;
import io.gig.coffeechat.domain.member.mentor.MentorCommand;
import io.gig.coffeechat.service.api.dto.member.MemberDto;
import io.gig.coffeechat.service.api.dto.mentor.MentorDto;
import io.gig.coffeechat.service.api.dto.mentor.MentorDtoMapper;
import io.gig.coffeechat.service.api.facade.MentorFacade;
import io.gig.coffeechat.service.api.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author : JAKE
 * @date : 2022/12/22
 */
@Slf4j
@RestController
@RequestMapping("members/{uuid}/mentor")
@RequiredArgsConstructor
public class MentorController {

    private final MentorDtoMapper mentorDtoMapper;
    private final MentorFacade mentorFacade;

    @PutMapping("university")
    @ResponseBody
    public ResponseEntity<ApiResponse> changeUniversity(
            @PathVariable String uuid,
            @RequestBody @Valid MentorDto.ChangeUniversityRequest request
    ) {
        MentorCommand.ChangeUniversity mentorCommand = mentorDtoMapper.of(request);
        boolean result = mentorFacade.changeUniversity(uuid, mentorCommand);
        MentorDto.Response response = mentorDtoMapper.of(result);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.OK);
    }

    @PutMapping("year")
    @ResponseBody
    public ResponseEntity<ApiResponse> changeYear(
            @PathVariable String uuid,
            @RequestBody @Valid MentorDto.ChangeYearRequest request
    ) {
        MentorCommand.ChangeYear mentorCommand = mentorDtoMapper.of(request);
        boolean result = mentorFacade.changeYear(uuid, mentorCommand);
        MentorDto.Response response = mentorDtoMapper.of(result);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.OK);
    }

}
