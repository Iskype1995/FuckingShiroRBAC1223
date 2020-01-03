package com.david.mapper;

import com.david.entity.User;
import com.david.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface UserMapper {

    User findUserByUsername(String username);
}