package com.example.demo.JWT;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class HmsJwtService {
    private static final Key SECRET_KEY;
    private static final Long EXPIRATION_MS;

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS)).addClaims(Map.of("roles", userDetails.getAuthorities())).signWith(SECRET_KEY).compact();
    }

    public String extractUsername(String token) {
        return (String)this.extractClaims(token, Claims::getSubject);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = this.extractUsername(token);
        return username.equals(userDetails.getUsername()) && !this.isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return this.extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return (Date)this.extractClaims(token, Claims::getExpiration);
    }

    private <T> T extractClaims(String token, Function<Claims, T> resolver) {
        Claims claims = (Claims)Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
        return (T)resolver.apply(claims);
    }

    static {
        SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        EXPIRATION_MS = 3600000L;
    }
}
