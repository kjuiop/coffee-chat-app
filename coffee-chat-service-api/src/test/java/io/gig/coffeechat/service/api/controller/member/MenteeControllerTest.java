package io.gig.coffeechat.service.api.controller.member;

import io.gig.coffeechat.service.api.config.ServiceApiTestConfig;
import io.gig.coffeechat.service.api.dto.member.SignUpDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
@SpringBootTest
@AutoConfigureMockMvc
class MenteeControllerTest extends ServiceApiTestConfig {

    @DisplayName("멘티_회원가입_테스트")
    @Test
    public void menteeSignUpTest() throws Exception {

        // given
        SignUpDto.MenteeDetailInfo menteeDetail = SignUpDto.MenteeDetailInfo.builder()
                .schoolName("언남고등학교")
                .year(1)
                .studentType("HIGH_SCHOOL_STUDENT")
                .build();


        SignUpDto.SignUp request = SignUpDto.SignUp.builder()
                .email("arneg0shua1@gmail.com")
                .nickname("jake1")
                .gender("M")
                .usageAuthority("MENTEE")
                .birth(LocalDate.of(1992,8,25))
                .menteeDetailInfo(menteeDetail)
                .build();

        String content = convertJsonToString(request);

        // when
        ResultActions result = mockMvc.perform(post("/api/members/3/sign-up")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        // then
        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.data.signUpToken").value(3))
        ;
    }
}