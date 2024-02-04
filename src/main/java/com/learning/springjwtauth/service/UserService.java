package com.learning.springjwtauth.service;

import com.learning.springjwtauth.dao.UserDAO;
import com.learning.springjwtauth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public User registerUser(User user) {
        return userDAO.saveUser(user);
    }
}
