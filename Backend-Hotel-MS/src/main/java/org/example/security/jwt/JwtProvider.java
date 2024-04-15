package org.example.security.jwt;

import com.google.api.client.util.Value;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.example.security.services.UserPrinciple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtProvider {
    private static final Logger log = LoggerFactory.getLogger(JwtProvider.class);
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expirationms}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {
        Instant expirationTime = Instant.now().plus(jwtExpirationMs, ChronoUnit.MILLIS);
        Date expirationDate = Date.from(expirationTime);
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
        Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        String compactTokenString = Jwts.builder()
            .claim("sub", userPrincipal.getUsername())
            .setExpiration(expirationDate)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();

        return "Bearer " + compactTokenString;
    }
    public String getUserNameFromJwtToken(String token) {
        byte[] secretBytes = jwtSecret.getBytes();
        Jws<Claims> jwsClaims = Jwts.parserBuilder()
                .setSigningKey(secretBytes)
                .build()
                .parseClaimsJws(token);
        return jwsClaims.getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String token) {

        try {
            byte[] secretBytes = jwtSecret.getBytes();
            Jwts.parser().setSigningKey(secretBytes).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
