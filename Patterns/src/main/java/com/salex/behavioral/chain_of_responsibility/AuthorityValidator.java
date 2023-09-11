package com.salex.behavioral.chain_of_responsibility;

import com.salex.behavioral.chain_of_responsibility.dao.ResourceDao;
import com.salex.behavioral.chain_of_responsibility.dao.UserDao;
import com.salex.behavioral.chain_of_responsibility.model.Authority;
import com.salex.behavioral.chain_of_responsibility.model.Resource;
import com.salex.behavioral.chain_of_responsibility.model.User;

public class AuthorityValidator extends Validator {
    protected AuthorityValidator(UserDao userDao, ResourceDao resourceDao) {
        super(userDao, resourceDao);
    }

    @Override
    public boolean validate(User user, Resource resource) {
        Resource resourceByContext = resourceDao.findResourceByContext(resource.getContext());
        if (resourceByContext == null) {
            return false;
        }
        Authority authority = user.getRole();
        if (resourceByContext.getPermissions().contains(authority)) {
            System.out.println("Authorization passed");
            if (nextHandler != null) {
                return nextHandler.validate(user, resource);
            }
        } else {
            return false;
        }
        return true;
    }
}
