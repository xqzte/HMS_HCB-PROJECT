package com.example.demo.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@Service
public class JwtAutheticationService {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256); // secure random key
    private static final long EXPIRATION_MS = 3600000; // 1 hour

//    // 1. Generate Token
//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>(); // extra info if you want
//        return createToken(claims, userDetails.getUsername());
//    }

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .addClaims(Map.of("roles", userDetails.getAuthorities()))
                .signWith(SECRET_KEY)
                .compact();
    }

    private <T> T extractClaims(String token, Function<Claims, T> resolver) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return resolver.apply(claims);
    }
    public String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    // 2. Extract Username
//    public String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    // 3. Extract Expiration Date
//    public Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }

    // 4. Generic claim extractor
//    private <T> T extractClaims(String token, Function<Claims, T> resolver) {
//        Claims claims = Jwts.parserBuilder()
//                .setSigningKey(SECRET_KEY)
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//
//        return resolver.apply(claims);
//    }
//    }

//    private Claims extractAllClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(SECRET_KEY)    // verify with the same key
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }

    // 5. Token validation
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }
    }
