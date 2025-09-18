package com.example.demo.Security;

import com.example.demo.Entities.Account;
import com.example.demo.Entities.Role;
import com.example.demo.Repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Account account =userRepository.findByEmail(name).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

        Role role = Role.valueOf(account.getRole());

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.addAll(role.getAuthorities());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()));



        // Build Spring Security user with both role and permissions
        return org.springframework.security.core.userdetails.User
                .withUsername(account.getUsername())
                .password(account.getPassword())
                .roles(account.getRole())
                .build();
    }
}