package org.medtech.medmeet.authentication.domain.service;

import org.medtech.medmeet.authentication.domain.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> fetchAll();    // getAll, fetchAll, getUser
    Optional<User> fetchById(Integer id);
    User save(User user);
    User update(User user);
    boolean deleteById(Integer id);
}
