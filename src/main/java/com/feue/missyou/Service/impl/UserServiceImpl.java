package com.feue.missyou.Service.impl;

import com.feue.missyou.Service.UserService;
import com.feue.missyou.model.User;
import com.feue.missyou.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Feue
 * @create 2021-08-06 17:16
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return this.userRepository.findOneById(id);
    }
}
