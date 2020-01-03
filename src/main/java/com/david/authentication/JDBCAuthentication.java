package com.david.authentication;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import java.beans.PropertyVetoException;

/**
 * Created by David
 * Project name: FuckingShiroRBAC1223
 * Created at 2019/12/24 15:09
 * Description:
 */
public class JDBCAuthentication {
    public static void main(String[] args) throws PropertyVetoException {
        //1.获得用户信息
        String username = null;
        String password = null;
        try {
            System.out.println("Ini该死的用户名：");
            username = new java.util.Scanner(System.in).nextLine();
            System.out.println("Ini该死的密码：");
            password = new java.util.Scanner(System.in).nextLine();
        } catch (Exception e) {
            System.err.println("肏！！！ FUUUUUCKKK!! 读取信息失败！");
            e.printStackTrace();
        } finally {
        }
        //2.创建JDBC凭证
        JdbcRealm jdbcRealm = new JdbcRealm();
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("tqzyy");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/shiro");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        jdbcRealm.setDataSource(dataSource);
        //3.
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(jdbcRealm);
        //4.
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        //5.
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            System.out.println("验证好了。");
        } catch (UnknownAccountException e) {
            System.err.println("妈个屄的，用户名错了！！");
            e.printStackTrace();
        } catch (IncorrectCredentialsException e) {
            System.err.println("妈个屄的，密码错了！！");
            e.printStackTrace();
        }
        finally {
        }
    }
}
