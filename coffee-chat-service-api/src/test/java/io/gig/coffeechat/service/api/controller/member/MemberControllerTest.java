package io.gig.coffeechat.service.api.controller.member;

import io.gig.coffeechat.service.api.config.ServiceApiTestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author : JAKE
 * @date : 2022/11/12
 */
@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest extends ServiceApiTestConfig {

    @DisplayName("이메일_인증_반영_테스트")
    @Test
    public void authMemberEmailValidateTest() throws Exception {

        // given

        // when
        ResultActions result = mockMvc.perform(get("/api/members/1/email-auth")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        // then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("OK"));

    }

    @DisplayName("이메일 중복 체크 테스트")
    @Test
    public void validEmailTest() throws Exception {

        // given
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("email", "copying_y@naver.com");

        // when
        ResultActions result = mockMvc.perform(get("/api/email-verify")
                .params(request)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        // then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.data.isValid").value(true));

    }

    @DisplayName("닉네임 중복 체크 테스트")
    @Test
    public void validNicknameTest() throws Exception {

        // given
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("nickname", "jake12");

        // when
        ResultActions result = mockMvc.perform(get("/api/nickname-verify")
                .params(request)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        // then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.data.isValid").value(true));

    }
}
