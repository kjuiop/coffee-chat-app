package io.gig.coffeechat.service.api.jwt;

import com.google.gson.Gson;
import io.gig.coffeechat.domain.exception.ErrorCode;
import io.gig.coffeechat.service.api.util.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
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
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    private final Logger logger = LoggerFactory.getLogger(JwtAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

        PrintWriter writer = response.getWriter();
        ErrorCode errorCode = ErrorCode.UNAUTHORIZED_USER;
        ApiResponse resVo = ApiResponse.ERROR(HttpStatus.FORBIDDEN, errorCode.getMessage());
        Gson gson = new Gson();

        try {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            writer.write(gson.toJson(resVo));
        } catch (NullPointerException e) {
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
