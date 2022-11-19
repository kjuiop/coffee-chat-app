package io.gig.coffeechat.service.api.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import io.gig.coffeechat.domain.member.auth.AuthServiceImpl;
import io.gig.coffeechat.service.api.util.ValidateRequestHeader;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * @author : JAKE
 * @date : 2022/11/16
 */
@Component
@RequiredArgsConstructor
public class FirebaseTokenFilter extends OncePerRequestFilter {

    @Autowired
    private ObjectMapper objectMapper;

    private final FirebaseAuth firebaseAuth;
    private final AuthServiceImpl authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // get the token from the request

        if (ValidateRequestHeader.checkAuthorization(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        FirebaseToken decodedToken;
        String token;
        try {
            token = ValidateRequestHeader.getAuthorizationToken(request);
            decodedToken = firebaseAuth.verifyIdToken(token);
            UserDetails user = authService.loadUserByUsername(decodedToken.getUid());
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    user, null, user.getAuthorities());
            authService.validateLoginUser(decodedToken.getUid(), decodedToken.getEmail());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (IllegalArgumentException e) {
            setUnauthorizedResponse(response, "HEADER INVALID_TOKEN");
            return;
        } catch (FirebaseAuthException e) {
            setUnauthorizedResponse(response, "FIREBASE INVALID_TOKEN : " + e.getMessage());
            return;
        } catch (NoSuchElementException e) {
            setUnauthorizedResponse(response, "USER NOT FOUND");
            return;
        } catch (AccessDeniedException e) {
            setUnauthorizedResponse(response, "USER NOT MATCH MEMBER DATA");
            return;
        }

        filterChain.doFilter(request, response);
    }

    private void setUnauthorizedResponse(HttpServletResponse response, String message) throws IOException {
        Map<String, Object> errorObject = new HashMap<String, Object>();
        int errorCode = 401;
        errorObject.put("message", message);
        errorObject.put("error", HttpStatus.UNAUTHORIZED);
        errorObject.put("code", errorCode);
        errorObject.put("timestamp", new Timestamp(new Date().getTime()));
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(errorCode);
        response.getWriter().write(objectMapper.writeValueAsString(errorObject));
    }
}
