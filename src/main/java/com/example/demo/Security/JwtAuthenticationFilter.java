package com.example.demo.Security;

import com.example.demo.Security.JwtProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;  // your custom class for generating/validating tokens
    private final MyUserDetailsService myUserDetailsService; // loads user from DB

    public JwtAuthenticationFilter(JwtProvider jwtProvider, MyUserDetailsService myUserDetailsService) {
        this.jwtProvider = jwtProvider;
        this.myUserDetailsService = myUserDetailsService;

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // 1. Get Authorization header
        String authHeader = request.getHeader("Authorization");

        String token = null;
        String username = null;

        // 2. Check if header is valid
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);

            try {
                username = this.jwtProvider.extractUsername(token);
            } catch (Exception e) {
                System.out.println("Invalid Token");
                throw new RuntimeException(e);
            }

            // remove "Bearer "
           // extract username from token
        }

        // 3. Validate token and set authentication
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);

            if (jwtProvider.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Set the authentication in the context
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // 4. Continue filter chain
        filterChain.doFilter(request, response);
    }
}
