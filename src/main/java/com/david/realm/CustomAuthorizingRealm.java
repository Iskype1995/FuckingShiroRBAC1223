package com.david.realm;

import com.david.entity.User;
import com.david.service.UserService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CustomAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.
        String username = (String) authenticationToken.getPrincipal();
        System.out.println("用户输入的用户名是："+username);
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
                    user, user.getuPassword(), "customRealm"
            );
            return simpleAuthenticationInfo;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1.
        User user = (User) principalCollection.getPrimaryPrincipal();
        //2.
        String roleSql = "select distinct r.r_name from user u left join user_role ur on u.u_id = ur.u_id \n" +
                "                            left join role r on ur.r_id = r.r_id \n" +
                "                            where u.u_account = ? ";
        String permissionSql = "select distinct p.p_name from user u left join user_role ur on u.u_id = ur.u_id \n" +
                "                            left join role r on ur.r_id = r.r_id\n" +
                "                            left join role_permission rp on r.r_id = rp.r_id\n" +
                "                            left join permission p on rp.p_id = p.p_id\n" +
                "                            where u.u_account = ? ";

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

        List<String> roles = jdbcTemplate.queryForList(roleSql, String.class, user.getuAccount());
        List<String> permissions = jdbcTemplate.queryForList(permissionSql, String.class, user.getuAccount());

        Set<String> roleSet = new HashSet<>(roles);
        Set<String> permissionSet = new HashSet<>(permissions);

        //3.
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roleSet);
        simpleAuthorizationInfo.addStringPermissions(permissions);

        return simpleAuthorizationInfo;
    }
}
