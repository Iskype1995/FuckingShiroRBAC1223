package com.david.authentication;

import com.david.realm.CustomAuthenticatingRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.dao.EmptyResultDataAccessException;

public class CustomAuthentication {
    public static void main(String[] args) {
        //1.
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
        //2.
        CustomAuthenticatingRealm customAuthenticatingRealm = new CustomAuthenticatingRealm();
        //3.
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //4.
        defaultSecurityManager.setRealm(customAuthenticatingRealm);
        //5.
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //4.创建Subject
        Subject subject = SecurityUtils.getSubject();
        //5.用token验证
        UsernamePasswordToken token1 = new UsernamePasswordToken(username, password);
        try {
            subject.login(token1);
            System.out.println("验证好了。");
        } catch (EmptyResultDataAccessException e){
            System.out.println("妈个屄的，用户名为空！");
            e.printStackTrace();
        }
          catch (UnknownAccountException e) {
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
