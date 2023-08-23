package com.salex.springsecurity.security.apikey.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

public class ApiKeyAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private final String apiKey;

    public ApiKeyAuthenticationToken(String apiKey, Collection<? extends GrantedAuthority> authorities) {
        super(apiKey, apiKey, authorities);
        this.apiKey = apiKey;
    }

}
