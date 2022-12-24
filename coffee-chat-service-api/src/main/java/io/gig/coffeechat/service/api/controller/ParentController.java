package io.gig.coffeechat.service.api.controller;

import io.gig.coffeechat.domain.member.parent.ParentCommand;
import io.gig.coffeechat.service.api.dto.mentor.MentorDto;
import io.gig.coffeechat.service.api.dto.parent.ParentDto;
import io.gig.coffeechat.service.api.dto.parent.ParentDtoMapper;
import io.gig.coffeechat.service.api.facade.ParentFacade;
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
@RequestMapping("members/{uuid}/parent")
@RequiredArgsConstructor
public class ParentController {

    private final ParentDtoMapper parentDtoMapper;
    private final ParentFacade parentFacade;

    @PutMapping("school-name")
    @ResponseBody
    public ResponseEntity<ApiResponse> changeSchoolName(
            @PathVariable String uuid,
            @RequestBody @Valid ParentDto.ChangeSchoolNameRequest request
    ) {
        ParentCommand.ChangeSchoolName parentCommand = parentDtoMapper.of(request);
        boolean result = parentFacade.changeSchoolName(uuid, parentCommand);
        ParentDto.Response response = parentDtoMapper.of(result);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.OK);
    }

    @PutMapping("year")
    @ResponseBody
    public ResponseEntity<ApiResponse> changeYear(
            @PathVariable String uuid,
            @RequestBody @Valid ParentDto.ChangeYearRequest request
    ) {
        ParentCommand.ChangeYear parentCommand = parentDtoMapper.of(request);
        boolean result = parentFacade.changeYear(uuid, parentCommand);
        ParentDto.Response response = parentDtoMapper.of(result);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.OK);
    }

}
