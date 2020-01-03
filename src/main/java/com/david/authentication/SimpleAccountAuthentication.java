package com.david.authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;

/*
 * subject认证方法
 * login(token)  logout()
 * isAuthencated()
 * getPrincapal()  getCredentials()
 */
public class SimpleAccountAuthentication {
    public static void main(String[] args) {
        //1.获取用户密码
        String username = null;
        String password = null;
        try {
            System.out.println("该死的用户名：");
            username = new java.util.Scanner(System.in).nextLine();
            System.out.println("该死的密码：");
            password = new java.util.Scanner(System.in).nextLine();
        } catch (Exception e) {
            System.err.println("肏！！！ FUUUUUCKKK!! 读取信息失败！");
            e.printStackTrace();
        } finally {
        }
        //2.创建SM
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //3.配置realm(第一种)
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        simpleAccountRealm.addAccount("david","123");
        simpleAccountRealm.addAccount("david","123");
        simpleAccountRealm.addAccount("peter","fuck");
        simpleAccountRealm.addAccount("oh_shit!","fuckingpieceofshit");
        simpleAccountRealm.addAccount("张三肏李四","zhangsanfuckslisi");
        simpleAccountRealm.addAccount("陈冠希5厘米大屌插的张柏芝淫水喷涌浪叫","edisonscrewfuck");
        simpleAccountRealm.addAccount("宋喆肮脏的鸡把肏的马蓉性高潮","songzhefucksmarong");
        securityManager.setRealm(simpleAccountRealm);
        //4.通过SecurityUtils获取Subject
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        //5.
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            System.out.println("验证通过！ FUUUUUCKKKK YEAH!!");
        } catch (AuthenticationException e) {
            System.err.println("验证失败！");
            e.printStackTrace();
        } finally {
        }
    }
}
