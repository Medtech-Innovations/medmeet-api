package org.medtech.medmeet.authentication.service;

import org.medtech.medmeet.authentication.domain.model.entity.User;
import org.medtech.medmeet.authentication.domain.persistence.UserRepository;
import org.medtech.medmeet.authentication.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public List<User> fetchAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> fetchById(Integer id) {
        if (userRepository.existsById(id)) {
            return userRepository.findById(id);
        } else {
            return Optional.empty();
        }
    }

    @Transactional
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
