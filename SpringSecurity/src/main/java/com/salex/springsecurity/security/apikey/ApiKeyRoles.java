package com.salex.springsecurity.security.apikey;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public enum ApiKeyRoles {
    USER("USER"),
    ADMIN("ADMIN");

    private String role;

    ApiKeyRoles(String role) {
        this.role = role;
    }

    public List<GrantedAuthority> getGrantedAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

}
