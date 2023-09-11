package com.salex.behavioral.chain_of_responsibility;

import com.salex.behavioral.chain_of_responsibility.dao.ResourceDao;
import com.salex.behavioral.chain_of_responsibility.dao.UserDao;
import com.salex.behavioral.chain_of_responsibility.model.Resource;
import com.salex.behavioral.chain_of_responsibility.model.User;

public class BlockValidator extends Validator {
    public BlockValidator(UserDao userDao, ResourceDao resourceDao) {
        super(userDao, resourceDao);
    }

    @Override
    public boolean validate(User user, Resource resource) {
        if (user.isBlocked()) {
            return false;
        }
        System.out.println("Validity passed");
        if (nextHandler != null) {
            return nextHandler.validate(user, resource);
        }
        return true;
    }
}
