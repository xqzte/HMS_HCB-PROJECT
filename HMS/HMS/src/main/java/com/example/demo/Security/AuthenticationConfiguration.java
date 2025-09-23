package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class AuthenticationConfiguration {

    @Autowired
        private final JwtAuthenticationFilter jwtAuthFilter;
    @Autowired
        private final UserDetailsService userDetailsService;



        public AuthenticationConfiguration( JwtAuthenticationFilter jwtAuthFilter, UserDetailsService userDetailsService) {
            this.jwtAuthFilter = jwtAuthFilter;
            this.userDetailsService = userDetailsService;
        }

        @Bean
        public AuthenticationManager authenticationManager(org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration config)throws Exception{
            return config.getAuthenticationManager();
        }


        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
            return http
                    .csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/auth/**", "/h2-console/**").permitAll()
                            .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                            .requestMatchers("/admin/**").hasRole("ADMIN")
                            .requestMatchers("/doctor/**").hasRole("DOCTOR")
                            .requestMatchers("/nurse/**").hasRole("NURSE")
                            .requestMatchers("/patient/**").hasRole("PATIENT")
                            .anyRequest().authenticated()
                    )
                    .userDetailsService(userDetailsService)
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                    .build();
        }

        //passwordEncoder.
        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

    }
