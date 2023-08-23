package com.salex.springsecurity.security.apikey.dao;

import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserDao {

    public Optional<User> findUserByUsername(String username);

}
