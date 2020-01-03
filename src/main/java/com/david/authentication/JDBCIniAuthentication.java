package com.david.authentication;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;

import java.beans.PropertyVetoException;

public class JDBCIniAuthentication {
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
        //2.创建SM
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:jdbc.ini");
        SecurityManager securityManager = iniSecurityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3,绑定主体
        Subject subject = SecurityUtils.getSubject();
        //4.用令牌验证
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
