package com.qf.mapper;

import com.qf.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    public User getUserByNameAndPWD(User user);
}
