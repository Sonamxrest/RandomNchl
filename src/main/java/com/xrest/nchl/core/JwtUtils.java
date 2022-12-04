package com.xrest.nchl.core;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

public class JwtUtils {
    static String key = "nchl";
    static String header = "Authorization";
    static String tokenType = "Bearer";

    static String generateToken(String data) {
        return JWT.create().withSubject(data).sign(Algorithm.HMAC256(key));
    }
    static String decode(String token) {
        return JWT.decode(token).getSubject();
    }
}
