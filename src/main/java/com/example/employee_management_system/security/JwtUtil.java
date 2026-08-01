package com.example.employee_management_system.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

@Component
@Slf4j
public class JwtUtil {

    private final SecretKey secretKey;

    private final long jwtExpiration;

    public JwtUtil(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.expiration}") long jwtExpiration
    ) {

        this.secretKey = Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );

        this.jwtExpiration = jwtExpiration;
    }

    /**
     * Generate JWT Token
     */
    public String generateToken(String username) {

        Date now = new Date();

        Date expiryDate = new Date(
                now.getTime() + jwtExpiration
        );

        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(secretKey)
                .compact();
    }

    /**
     * Extract Username
     */
    public String extractUsername(String token) {

        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extract Expiration Date
     */
    public Date extractExpiration(String token) {

        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Generic Claim Extractor
     */
    public <T> T extractClaim(
            String token,
            Function<Claims, T> claimsResolver
    ) {

        Claims claims = extractAllClaims(token);

        return claimsResolver.apply(claims);
    }

    /**
     * Extract All Claims
     */
    private Claims extractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * Check Whether Token Has Expired
     */
    public boolean isTokenExpired(String token) {

        return extractExpiration(token).before(new Date());
    }

    /**
     * Validate Token Against User
     */
    public boolean validateToken(
            String token,
            UserDetails userDetails
    ) {

        try {

            String username = extractUsername(token);

            return username.equals(userDetails.getUsername())
                    && !isTokenExpired(token);

        } catch (ExpiredJwtException ex) {

            log.warn("JWT expired: {}", ex.getMessage());

        } catch (MalformedJwtException ex) {

            log.warn("Malformed JWT: {}", ex.getMessage());

        } catch (UnsupportedJwtException ex) {

            log.warn("Unsupported JWT: {}", ex.getMessage());

        } catch (SecurityException ex) {

            log.warn("Invalid JWT signature: {}", ex.getMessage());

        } catch (IllegalArgumentException ex) {

            log.warn("JWT token is empty: {}", ex.getMessage());

        } catch (JwtException ex) {

            log.warn("JWT validation failed: {}", ex.getMessage());

        } catch (Exception ex) {

            log.error("Unexpected JWT error: {}", ex.getMessage());

        }

        return false;
    }

    /**
     * Validate Token Without UserDetails
     */
    public boolean validateToken(String token) {

        try {

            return !isTokenExpired(token);

        } catch (Exception ex) {

            log.warn("Invalid JWT: {}", ex.getMessage());

            return false;
        }
    }

}