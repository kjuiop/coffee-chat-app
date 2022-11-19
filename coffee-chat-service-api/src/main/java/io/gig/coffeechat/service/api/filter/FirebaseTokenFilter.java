package io.gig.coffeechat.service.api.filter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import io.gig.coffeechat.domain.member.auth.AuthServiceImpl;
import io.gig.coffeechat.service.api.util.ValidateRequestHeader;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
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
import java.util.NoSuchElementException;

/**
 * @author : JAKE
 * @date : 2022/11/16
 */
@Component
@RequiredArgsConstructor
public class FirebaseTokenFilter extends OncePerRequestFilter {

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
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (IllegalArgumentException e) {
            setUnauthorizedResponse(response, "HEADER INVALID_TOKEN");
            return;
        } catch (FirebaseAuthException e) {
            setUnauthorizedResponse(response, "FIREBASE INVALID_TOKEN");
            return;
        } catch (NoSuchElementException e) {
            setUnauthorizedResponse(response, "USER_NOT_FOUND");
            return;
        }

        filterChain.doFilter(request, response);
    }

    private void setUnauthorizedResponse(HttpServletResponse response, String code) throws IOException {
        response.setStatus(HttpStatus.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"code\":\"INVALID_TOKEN\"}");
    }
}
