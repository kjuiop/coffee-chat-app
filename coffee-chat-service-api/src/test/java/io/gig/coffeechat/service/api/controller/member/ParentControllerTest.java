package io.gig.coffeechat.service.api.controller.member;

import io.gig.coffeechat.service.api.config.ServiceApiTestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

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

        // when
        ResultActions result = mockMvc.perform(post("/api/members/parents/4/sign-up")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        // then
        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.status").value("OK"))
        ;
    }

}