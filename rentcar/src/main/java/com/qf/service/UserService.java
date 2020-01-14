package com.qf.service;

import com.qf.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User getUserByNameAndPWD(User user);
}
