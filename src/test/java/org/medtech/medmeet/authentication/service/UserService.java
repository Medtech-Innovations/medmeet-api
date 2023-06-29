package org.medtech.medmeet.authentication.service;

import org.medtech.medmeet.authentication.domain.model.entity.User;

public interface UserService {
    User buscarporId(Integer id);
}
