package com.example.demo.JWT;

import com.example.demo.Security.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class HmsJwtAuthFilter extends OncePerRequestFilter {
    private final HmsJwtService hmsJwtService;
    private final MyUserDetailsService userDetailsService;

    public HmsJwtAuthFilter(HmsJwtService hmsJwtService, MyUserDetailsService userDetailsService) {
        this.hmsJwtService = hmsJwtService;
        this.userDetailsService = userDetailsService;
    }

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String prefix = "Bearer ";
        String jwt = null;
        String username = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);

            try {
                username = this.hmsJwtService.extractUsername(jwt);
            } catch (Exception e) {
                System.out.println("Invalid Token");
                throw new RuntimeException(e);
            }
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails user = this.userDetailsService.loadUserByUsername(username);
            if (this.hmsJwtService.isTokenValid(jwt, user)) {
                UsernamePasswordAuthenticationToken AuthToken = new UsernamePasswordAuthenticationToken(user, (Object)null, user.getAuthorities());
                AuthToken.setDetails((new WebAuthenticationDetailsSource()).buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(AuthToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
