package io.gig.coffeechat.service.api.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : JAKE
 * @date : 2023/01/22
 */
@Component
public class TokenProvider implements InitializingBean {

    private final Logger logger = LoggerFactory.getLogger(TokenProvider.class);

    private final String secret;
    private static final long ACCESS_TOKEN_VALID_TIME = 1000L * 60 * 30;
    private static final long REFRESH_TOKEN_VALID_TIME = 1000L * 60 * 60 * 24 * 7;
    private Key key;

    public TokenProvider(@Value("${jwt.secret}") String secret) {
        this.secret = secret;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    /* token 생성 algorithm */
    public String createAccessToken(String uid, List<String> roles) {
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(uid)
                .claim("roles", roles)
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALID_TIME))
                .compact();
    }

    public String createRefreshToken(String uid, List<String> roles) {
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(uid)
                .claim("roles", roles)
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALID_TIME))
                .compact();
    }

    /* 인증 정보 조회 */
    public Authentication getAuthentication(String token) {

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get("roles").toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        User principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    /* token 유효성 검증 */
    public boolean validateToken(String token) {

        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SignatureException | MalformedJwtException e) {
            logger.error("잘못된 JWT 서명입니다.");
            return false;
        } catch (ExpiredJwtException e) {
            logger.error("만료된 JWT 토큰입니다.");
            return false;
        } catch (UnsupportedJwtException e) {
            logger.error("지원하지 않는 JWT 토큰입니다.");
            return false;
        } catch (IllegalArgumentException e) {
            logger.error("JWT 토큰이 잘못되었습니다.");
            return false;
        }
    }

}
