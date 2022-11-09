package io.gig.coffeechat.service.api.controller;

import io.gig.coffeechat.service.api.config.ServiceApiTestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
class MentorControllerTest extends ServiceApiTestConfig {

    @DisplayName("멘토_회원가입_테스트")
    @Test
    public void mentorSignUpTest() throws Exception {

        // given

        // when
        ResultActions result = mockMvc.perform(post("/api/members/mentors/1/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        // then
        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.status").value("OK"))
        ;
    }

}