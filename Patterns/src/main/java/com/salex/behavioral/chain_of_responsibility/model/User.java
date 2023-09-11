package com.salex.behavioral.chain_of_responsibility.model;

public class User {

    private String name;
    private String password;
    private Authority role;
    private boolean isBlocked;

    public User(String name, String password, Authority role, boolean isBlocked) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.isBlocked = isBlocked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Authority getRole() {
        return role;
    }

    public void setRole(Authority role) {
        this.role = role;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}

