package com.qf.service.impl;

import com.qf.entity.User;
import com.qf.mapper.UserMapper;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServerImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByNameAndPWD(User user) {
        return userMapper.getUserByNameAndPWD(user);
    }
}
