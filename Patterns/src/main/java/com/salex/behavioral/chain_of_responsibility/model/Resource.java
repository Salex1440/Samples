package com.salex.behavioral.chain_of_responsibility.model;

import java.util.List;

public class Resource {
    private String context;
    private List<Authority> permissions;

    public Resource(String context, List<Authority> permissions) {
        this.context = context;
        this.permissions = permissions;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public List<Authority> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Authority> permissions) {
        this.permissions = permissions;
    }
}
