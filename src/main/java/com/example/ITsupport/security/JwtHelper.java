package com.example.ITsupport.security;



import com.example.ITsupport.enums.role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class JwtHelper {
    public static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final int MINUTES =3600;
    public static String generateToken(String username , role Role) {
        var now= Instant.now();
        return Jwts.builder()
                .subject(username)
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .expiration(Date.from(now.plus(MINUTES, ChronoUnit.MINUTES)))
                .claim("role",Role.name())
                .compact();
    }

    public static String extractUsername(String token) {
        return getTokenBody(token).getSubject();
    }
    private static Claims getTokenBody(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (SignatureException | ExpiredJwtException e) { // Invalid signature or expired token
            throw new AccessDeniedException("Access denied: " + e.getMessage());
        }
    }
    public static Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) ;
    }

}
