package com.david.realm;

import com.david.entity.User;
import com.david.service.UserService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomAuthenticatingRealm extends AuthenticatingRealm {



    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取账号和密码
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        System.out.println("用户："+username+"， 密码："+password);
        //2.查询数据库
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("tqzyy");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/shiro");
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        //3.判断返回结果
        String sql = "select * from user where u_account = ?;";
        User user;
        user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setuId(resultSet.getInt("u_id"));
                user.setuName(resultSet.getString("u_name"));
                user.setuInfo(resultSet.getString("u_info"));
                user.setuAccount(resultSet.getString("u_account"));
                user.setuPassword(resultSet.getString("u_password"));
                System.out.println("查询到的user为："+user);
                return user;
            }
        },username);
        if (user == null){
            return null;
        }else{
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                    user.getuAccount(), user.getuPassword(), "customRealm"
            );
            return simpleAuthenticationInfo;
        }
    }
}
