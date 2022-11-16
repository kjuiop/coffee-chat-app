package io.gig.coffeechat.service.api.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : JAKE
 * @date : 2022/11/16
 */
public class ValidateRequestHeader {

    private static final String AUTHORIZATION = "Authorization";

    public static String getAuthorizationToken(String header) {
        if (StringUtils.isEmpty(header)) {
            throw new IllegalArgumentException("Invalid authorization header");
        }
        header.replace("Bearer ", "");
        // Authorization: Bearer <access_token>
        if (header == null || !header.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid authorization header");
        }
        // Remove Bearer from string
        String[] parts = header.split(" ");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid authorization header");
        }
        // Get token
        return parts[1];
    }

    public static String getAuthorizationToken(HttpServletRequest request) {
        return getAuthorizationToken(request.getHeader("Authorization"));
    }

    public static Boolean checkAuthorization(HttpServletRequest request) {
        return request.getHeader(AUTHORIZATION) == null;
    }

}
