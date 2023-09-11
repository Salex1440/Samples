package com.salex.behavioral.chain_of_responsibility;

import com.salex.behavioral.chain_of_responsibility.dao.ResourceDao;
import com.salex.behavioral.chain_of_responsibility.dao.UserDao;
import com.salex.behavioral.chain_of_responsibility.model.Resource;
import com.salex.behavioral.chain_of_responsibility.model.User;

public class AuthenticationValidator extends Validator {
    public AuthenticationValidator(UserDao userDao, ResourceDao resourceDao) {
        super(userDao, resourceDao);
    }

    @Override
    public boolean validate(User user, Resource resource) {
        User userByName = userDao.findUserByName(user.getName());
        if (userByName == null) {
            return false;
        }
        if (user.getPassword().equals(userByName.getPassword())) {
            System.out.println("Authentication passed");
            if (nextHandler != null) {
                return nextHandler.validate(user, resource);
            }
        } else {
            return false;
        }
        return true;
    }
}
