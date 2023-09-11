package com.salex.behavioral.chain_of_responsibility.dao;

import com.salex.behavioral.chain_of_responsibility.model.Authority;
import com.salex.behavioral.chain_of_responsibility.model.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceDao {

    private final Map<String, Resource> resources = new HashMap<>();

    public ResourceDao() {
        resources.put("for user", new Resource("for users", List.of(Authority.USER, Authority.ADMIN)));
        resources.put("for admin", new Resource("for admins", List.of(Authority.ADMIN)));
    }

    public Resource findResourceByContext(String context) {
        return resources.get(context);
    }
}
