package com.salex.behavioral.chain_of_responsibility;

import com.salex.behavioral.chain_of_responsibility.dao.ResourceDao;
import com.salex.behavioral.chain_of_responsibility.dao.UserDao;
import com.salex.behavioral.chain_of_responsibility.model.Resource;
import com.salex.behavioral.chain_of_responsibility.model.User;

/**
 * Цепочка обязанностей (Chain of responsibility) — поведенческий шаблон проектирования,
 * предназначенный для организации в системе уровней ответственности.
 */
public abstract class Validator {

    protected Validator nextHandler = null;
    protected final UserDao userDao;
    protected final ResourceDao resourceDao;

    protected Validator(UserDao userDao, ResourceDao resourceDao) {
        this.userDao = userDao;
        this.resourceDao = resourceDao;
    }

    public abstract boolean validate(User user, Resource resource);

    public void setNext(Validator handler) {
        nextHandler = handler;
    }

}
