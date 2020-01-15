package com.qf.mapper;

import com.qf.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    public User getUserByNameAndPWD(User user);
    public Integer register(User user);
    public Integer updateTcl(String tel,Integer id);
    public User   getUserByTel(String tel);

}
