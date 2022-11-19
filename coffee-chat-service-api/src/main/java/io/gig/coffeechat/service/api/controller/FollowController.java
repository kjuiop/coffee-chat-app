package io.gig.coffeechat.service.api.controller;

import io.gig.coffeechat.domain.member.MemberInfo;
import io.gig.coffeechat.service.api.dto.follow.FollowDto;
import io.gig.coffeechat.service.api.dto.follow.FollowDtoMapper;
import io.gig.coffeechat.service.api.dto.member.MemberDto;
import io.gig.coffeechat.service.api.dto.member.MemberDtoMapper;
import io.gig.coffeechat.service.api.facade.FollowFacade;
import io.gig.coffeechat.service.api.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author : JAKE
 * @date : 2022/11/19
 */

@RestController
@RequestMapping("follow")
@RequiredArgsConstructor
public class FollowController {

    private final MemberDtoMapper memberDtoMapper;
    private final FollowDtoMapper followDtoMapper;
    private final FollowFacade followFacade;

    @PostMapping
    @ResponseBody
    public ResponseEntity<ApiResponse> create(
            @RequestBody @Valid FollowDto.FollowRequest request
            ) {
        boolean result = followFacade.create(request);
        FollowDto.Response response = followDtoMapper.of(result);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.OK);
    }

    @GetMapping("{uuid}")
    public ResponseEntity<ApiResponse> getFollowingList(
            @PathVariable("uuid") String uuid
    ) {
        List<MemberInfo.Main> members = followFacade.getFollowingList(uuid);
        List<MemberDto.Main> response = memberDtoMapper.of(members);
        return new ResponseEntity<>(ApiResponse.OK(response), HttpStatus.OK);
    }
}
