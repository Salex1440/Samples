package com.salex.behavioral.chain_of_responsibility.dao;

import com.salex.behavioral.chain_of_responsibility.model.Authority;
import com.salex.behavioral.chain_of_responsibility.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private final Map<String, User> users = new HashMap<>();

    public UserDao() {
        users.put("user", new User("user", "user", Authority.USER, false));
        users.put("admin", new User("admin", "admin", Authority.ADMIN, false));
    }

    public User findUserByName(String name) {
        return users.get(name);
    }

}
