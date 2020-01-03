package com.david;

import com.david.entity.User;
import com.david.mapper.UserMapper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class FuckCodingTest {

    @Test
    public void fuck() throws IOException {
        String md5_test = new Md5Hash("123", "456", 10).toString();
        System.out.println("结果test："+md5_test);
    }
}
