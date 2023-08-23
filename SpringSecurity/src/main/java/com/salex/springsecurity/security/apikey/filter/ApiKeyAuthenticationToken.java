package com.salex.springsecurity.security.apikey.filter;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;

public class ApiKeyAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private final String apiKey;

    public ApiKeyAuthenticationToken(String apiKey) {
        super(apiKey, apiKey, AuthorityUtils.NO_AUTHORITIES);
        this.apiKey = apiKey;
    }

}
