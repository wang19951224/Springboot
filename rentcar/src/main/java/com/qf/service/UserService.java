package com.qf.service;

import com.qf.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User getUserByNameAndPWD(User user);
    public Integer register(User user);
    public Integer updateTcl(String tel,Integer id);
    public User   getUserByTel(String tel);
}
