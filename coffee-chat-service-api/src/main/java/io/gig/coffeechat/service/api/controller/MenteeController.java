package io.gig.coffeechat.service.api.controller;

import io.gig.coffeechat.domain.member.mentee.MenteeCommand;
import io.gig.coffeechat.service.api.dto.mentee.MenteeDto;
import io.gig.coffeechat.service.api.dto.mentee.MenteeDtoMapper;
import io.gig.coffeechat.service.api.facade.MenteeFacade;
import io.gig.coffeechat.service.api.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author : JAKE
 * @date : 2022/12/24
 */
@Slf4j
@RestController
@RequestMapping("members/{uuid}/mentee")
@RequiredArgsConstructor
public class MenteeController {

    private final MenteeDtoMapper menteeDtoMapper;
    private final MenteeFacade menteeFacade;

    @PutMapping("school-name")
    @ResponseBody
    public ResponseEntity<ApiResponse> changeSchoolName(
            @PathVariable String uuid,
            @RequestBody @Valid MenteeDto.ChangeSchoolNameRequest request
    ) {
        MenteeCommand.ChangeSchoolName menteeCommand = menteeDtoMapper.of(request);
        boolean result = menteeFacade.changeSchoolName(uuid, menteeCommand);
        MenteeDto.Response response = menteeDtoMapper.of(result);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.OK);
    }

    @PutMapping("year")
    @ResponseBody
    public ResponseEntity<ApiResponse> changeYear(
            @PathVariable String uuid,
            @RequestBody @Valid MenteeDto.ChangeYearRequest request
    ) {
        MenteeCommand.ChangeYear menteeCommand = menteeDtoMapper.of(request);
        boolean result = menteeFacade.changeYear(uuid, menteeCommand);
        MenteeDto.Response response = menteeDtoMapper.of(result);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.OK);
    }

}
