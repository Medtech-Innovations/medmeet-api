package org.medtech.medmeet.contact.domain.service;

import org.medtech.medmeet.contact.domain.model.entity.User;

import java.util.List;

public interface UserService {
    List<User>fetchAll();
    User fetchById(Integer id);
    User save(User user);
    User update(User user);
    boolean deleteById(Integer id);
}
