package com.salex.springsecurity.security.apikey.dao;

import com.salex.springsecurity.security.apikey.ApiKeyRoles;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
                ApiKeyRoles.USER.getGrantedAuthorities()),
                new User(
                    passwordEncoder.encode("adminKey"),
                    "adminKey",
                    ApiKeyRoles.ADMIN.getGrantedAuthorities())
            );
    }

}
