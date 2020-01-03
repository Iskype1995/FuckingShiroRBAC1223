package com.david.service;

import com.david.entity.User;

/**
 * Created by David
 * Project name: FuckingShiroRBAC1223
 * Created at 2019/12/23 22:29
 * Description:
 */
public interface UserService {

    User findUserByUsername(String username);

}
