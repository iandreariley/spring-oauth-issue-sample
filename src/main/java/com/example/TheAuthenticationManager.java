package com.example;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class TheAuthenticationManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            String username = authentication.getPrincipal().toString();
            String password = authentication.getCredentials().toString();
            return new UsernamePasswordAuthenticationToken(username, password, authentication.getAuthorities());
        } catch (Exception e) {
            throw new AuthenticationException("Some part of authentication failed.", e){};
        }
    }
}
