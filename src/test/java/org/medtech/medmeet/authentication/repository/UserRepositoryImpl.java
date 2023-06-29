package org.medtech.medmeet.authentication.repository;

import org.medtech.medmeet.authentication.domain.model.entity.User;
import org.medtech.medmeet.authentication.util.UserValidator;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public User findById(Integer id) {
        UserValidator.validateUserId(id);
        return new User(1,"FirstName","LastName","UserName","Password");
    }
}
