package com.salex.springsecurity.security.apikey.dao;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.salex.springsecurity.security.apikey.ApiKeyRoles.ADMIN;
import static com.salex.springsecurity.security.apikey.ApiKeyRoles.USER;

@Repository("fake")
public class FakeUserDaoImpl implements UserDao {

    private final PasswordEncoder passwordEncoder;

    public FakeUserDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return getUsers().stream()
            .filter(user -> user.getUsername().equals(username))
            .findFirst();
    }

    private List<User> getUsers() {
        return List.of(
            new User(
                "userKey",
                passwordEncoder.encode("userKey"),
                USER.getGrantedAuthorities()),
            new User(
                "adminKey",
                passwordEncoder.encode("adminKey"),
                ADMIN.getGrantedAuthorities())
            );
    }

}
