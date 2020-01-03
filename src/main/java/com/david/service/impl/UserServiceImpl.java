package com.david.service.impl;

import com.david.entity.User;
import com.david.mapper.UserMapper;
import com.david.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by David
 * Project name: FuckingShiroRBAC1223
 * Created at 2019/12/23 22:29
 * Description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        User user = userMapper.findUserByUsername(username);
        return user;
    }
}
