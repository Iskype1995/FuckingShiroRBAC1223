package com.david.realm;

import com.david.entity.Permission;
import com.david.entity.Role;
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
import org.apache.shiro.util.ByteSource;
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

/*
 * SSM整合认证Realm：
 * 1.salt存在数据库，加密次数本地配置
 * 2.
 */

@Component
public class CustomSSMAuthorizingRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.
        String username = (String) authenticationToken.getPrincipal();
        System.out.println("用户输入的用户名是：" + username);
        //2.查询数据库
        System.out.println("service启动。");
        User user = userService.findUserByUsername(username);
        System.out.println("查询到的用户为："+user.toString());
        //3.判断返回结果
        if (user == null) {
            return null;
        } else {
            //1.用户存在时，处理盐
            String salt = user.getSalt();
            ByteSource salt_source = ByteSource.Util.bytes(salt);
            //2.转存为凭证
            SimpleAuthenticationInfo simpleAuthenticationInfo = new
                    SimpleAuthenticationInfo(user,user.getuPassword(),salt_source,"customSSMRealm");

            return simpleAuthenticationInfo;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1.获取Realm中的user对象
        User user = (User) principalCollection.getPrimaryPrincipal();
        //2.将user中的roles和perms转换成Set
        Set<String> roles = new HashSet<>();
        Set<String> permissions = new HashSet<>();
        if (user != null) {
            List<Role> roles1 = user.getRoles();
            if (roles1 != null) {
                for (Role role : roles1) {
                    roles.add(role.getrName());
                    //权限
                    List<Permission> permissionslist = role.getPermissions();
                    if (permissionslist != null) {
                        for (Permission permission : permissionslist) {
                            permissions.add(permission.getpName());
                        }
                    }
                }
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }
}