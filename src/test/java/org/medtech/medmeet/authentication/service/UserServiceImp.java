package org.medtech.medmeet.authentication.service;

import lombok.AllArgsConstructor;
import org.medtech.medmeet.authentication.domain.model.entity.User;
import org.medtech.medmeet.authentication.repository.UserRepository;

@AllArgsConstructor
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;

    @Override
    public User buscarporId(Integer id) {
        User user = userRepository.findById(id);
        if (user.getId()<20){
            user.setId(user.getId()*2);
        }else {
            user.setId(user.getId()*5);
        }
        return user;
    }
}
