package com.salex.springsecurity.security.apikey;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.salex.springsecurity.security.apikey.ApiKeyPermissions.READ;
import static com.salex.springsecurity.security.apikey.ApiKeyPermissions.WRITE;

public enum ApiKeyRoles {
    GUEST(List.of()),
    USER(List.of(
        READ)),
    ADMIN(List.of(
        READ,
        WRITE));

    private final Collection<ApiKeyPermissions> permissions;

    ApiKeyRoles(Collection<ApiKeyPermissions> permissions) {
        this.permissions = permissions;
    }

    public List<GrantedAuthority> getGrantedAuthorities() {
        List<GrantedAuthority> authorities = permissions.stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

}
