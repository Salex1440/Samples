package com.salex.behavioral.chain_of_responsibility;

import com.salex.behavioral.chain_of_responsibility.dao.ResourceDao;
import com.salex.behavioral.chain_of_responsibility.dao.UserDao;
import com.salex.behavioral.chain_of_responsibility.model.Authority;
import com.salex.behavioral.chain_of_responsibility.model.Resource;
import com.salex.behavioral.chain_of_responsibility.model.User;
import org.junit.jupiter.api.Test;

import java.util.List;

class ChainOfResponsibilityTest {

    @Test
    public void test() {
        UserDao userDao = new UserDao();
        ResourceDao resourceDao = new ResourceDao();
        Validator authentication = new AuthenticationValidator(userDao, resourceDao);
        Validator authorization = new AuthorityValidator(userDao, resourceDao);
        Validator blocker = new BlockValidator(userDao, resourceDao);
        authentication.setNext(authorization);
        authorization.setNext(blocker);
        User user1 = new User("user", "user", Authority.USER, false);
        Resource rUser = new Resource("for user", List.of(Authority.USER, Authority.ADMIN));
        Resource rAdmin = new Resource("for admin", List.of(Authority.ADMIN));
        User user2 = new User("user", "", Authority.USER, false);
        User user3 = new User("user", "user", Authority.USER, true);

        System.out.println(authentication.validate(user1, rUser));
        System.out.println();
        System.out.println(authentication.validate(user2, rUser));
        System.out.println();
        System.out.println(authentication.validate(user1, rAdmin));
        System.out.println();
        System.out.println(authentication.validate(user3, rUser));

    }

}