package io.gig.coffeechat.service.api.jwt;

import com.google.gson.Gson;
import io.gig.coffeechat.domain.exception.ErrorCode;
import io.gig.coffeechat.service.api.util.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : JAKE
 * @date : 2023/01/22
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        PrintWriter writer = response.getWriter();
        ApiResponse resVo = ApiResponse.ERROR(HttpStatus.FORBIDDEN, ErrorCode.UNAUTHORIZED_USER.getMessage());
        Gson gson = new Gson();

        try {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            writer.write(gson.toJson(resVo));
        } catch(NullPointerException e) {
            logger.error("응답 메시지 작성 에러", e);
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }

        response.getWriter().write(gson.toJson(resVo));
    }
}
