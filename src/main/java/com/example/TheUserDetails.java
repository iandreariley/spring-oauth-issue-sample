package com.example;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

/**
 * Basic User class.
 */
public class TheUserDetails implements UserDetails {
    
    public static final SimpleGrantedAuthority authority = new SimpleGrantedAuthority("God");
    public static final HashSet<GrantedAuthority> authorities = new HashSet<GrantedAuthority>(){{ add(authority); }};
    
    private final String password;
    private final String name;

    public TheUserDetails(String name, String password) {
        this.name = name;
        this.password = password;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
