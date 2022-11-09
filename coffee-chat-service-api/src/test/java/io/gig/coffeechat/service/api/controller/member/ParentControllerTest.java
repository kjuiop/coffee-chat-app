package io.gig.coffeechat.service.api.controller.member;

import io.gig.coffeechat.service.api.config.ServiceApiTestConfig;
import io.gig.coffeechat.service.api.dto.parent.ParentDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
class ParentControllerTest extends ServiceApiTestConfig {

    @DisplayName("멘토_회원가입_테스트")
    @Test
    public void  parentSignUpTest() throws Exception {

        // given
        ParentDto.DetailInfo parentDetailInfo = ParentDto.DetailInfo.builder()
                .schoolName("언남고등학교")
                .year(3)
                .studentType("REPEATER_STUDENT")
                .build();

        ParentDto.SignUpRequest request = ParentDto.SignUpRequest
                .builder()
                .email("arneg0shua@gmail.com")
                .nickname("jake")
                .gender("M")
                .usageAuthority("MENTOR")
                .birth(LocalDate.of(1992,8,25))
                .parentDetailInfo(parentDetailInfo)
                .build();

        String content = convertJsonToString(request);

        // when
        ResultActions result = mockMvc.perform(post("/api/members/parents/2/sign-up")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        // then
        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.data.signUpToken").value(2))
        ;
    }

}