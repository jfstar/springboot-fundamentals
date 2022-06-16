package com.fundamentosplatzi.springboot.fundamentos.service;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserService {
    private final Log LG  = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<User> users)
    {
        users.stream()
            .peek(user -> LG.info("Usuario insertado: "+ user))
            .forEach(userRepository::save);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }
}
