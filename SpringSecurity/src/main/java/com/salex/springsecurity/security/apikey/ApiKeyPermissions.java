package com.salex.springsecurity.security.apikey;

public enum ApiKeyPermissions {

    READ("read"),
    WRITE("write");

    private final String permission;
    ApiKeyPermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
