package org.medtech.medmeet.authentication.mapping;

import org.medtech.medmeet.authentication.domain.model.entity.User;
import org.medtech.medmeet.authentication.resource.CreateUserResource;
import org.medtech.medmeet.authentication.resource.UpdateUserResource;
import org.medtech.medmeet.authentication.resource.UserResource;
import org.medtech.medmeet.authentication.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class UserMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public User toModel(CreateUserResource resource) {
        return this.mapper.map(resource, User.class);
    }
    public User toModel(UpdateUserResource resource) {
        return this.mapper.map(resource, User.class);
    }

    public UserResource toResource(User student) {
        return this.mapper.map(student, UserResource.class);
    }


}
