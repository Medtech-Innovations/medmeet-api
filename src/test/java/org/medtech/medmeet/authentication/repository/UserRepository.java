package org.medtech.medmeet.authentication.repository;

import org.medtech.medmeet.authentication.domain.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    User findById(Integer id);
}
