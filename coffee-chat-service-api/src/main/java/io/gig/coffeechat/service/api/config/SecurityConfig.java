package io.gig.coffeechat.service.api.config;

import io.gig.coffeechat.service.api.jwt.JwtAccessDeniedHandler;
import io.gig.coffeechat.service.api.jwt.JwtAuthenticationEntryPoint;
import io.gig.coffeechat.service.api.jwt.JwtSecurityConfig;
import io.gig.coffeechat.service.api.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author : JAKE
 * @date : 2023/01/22
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    private final TokenProvider tokenProvider;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("resources/**", "/favicon.ico");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf().disable()

                /* 401, 403 Exception 핸들링 */
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                /* http basic, formLogin 사용하지 않음 */
                .and()
                .httpBasic().disable()
                .formLogin().disable()
                .headers().frameOptions().disable().and()
                .cors()

                /* 세션 사용하지 않음 */
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                /* HttpServletRequest 를 사용하는 요청들에 대한 접근 제한 설정 */
                .and()
                .authorizeRequests()
                .antMatchers("/api/health-check", "/api/sign-up/**", "/init-data")
                .permitAll()

                /* JwtSecurityConfig 적용 */
                .and()
                .apply(new JwtSecurityConfig(tokenProvider))

                .and()
                .build();
    }
}
