package com.david.authorization;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 先认证通过了才能授权
 * SimpleAccount只能检查角色，不能管到权限
 * subject核心方法：
 * 有返回值，不抛异常： hasRole/hasRoles/hasAllRoles -> String role/List<String> roles/Collection<String> roles - boolean/boolean[]
 * 无返回值，抛异常：   checkRole/checkRoles  -> UnauthorizationException
 */
public class SimpleAccountAuthorization {
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
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //3.Realm
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        simpleAccountRealm.addAccount("david","123","CEO","manager","av");
        simpleAccountRealm.addAccount("peter","111","fucker","av");
        simpleAccountRealm.addAccount("陈冠希","edison","张柏芝拍摄家","阿娇拍照");
        //4.
        securityManager.setRealm(simpleAccountRealm);
        //5,
        SecurityUtils.setSecurityManager(securityManager);
        //6.
        Subject subject = SecurityUtils.getSubject();
        //7.
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //8.
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
        if(subject.isAuthenticated()){
            //todo 认证通过时
            Scanner sc = new Scanner(System.in);
            System.out.println("开始授权，请输入角色！");
            List<String> roles = new ArrayList<>();
            String input;
            while(!(input=sc.nextLine()).equals("")){
                roles.add(input);
            }
            try {
                boolean[] hasRoles = subject.hasRoles(roles);
                for(int i=0;i<hasRoles.length;i++){
                    System.out.println("用户"+hasRoles[i]+"拥有角色"+(i+1));
                }
            } catch (AuthorizationException e) {
                e.printStackTrace();
            }

            System.out.println();
            System.out.println();
            //
            System.out.println("开始授权，请输入3个角色！");
            String role1 = sc.nextLine();
            String role2 = sc.nextLine();
            String role3 = sc.nextLine();
            sc.close();
            try {
                subject.checkRoles(role1, role2, role3);
                System.out.println("用户拥有角色："+role1+role2+role3);
            } catch (AuthorizationException e) {
                System.err.println("用户不拥有角色："+role1+role2+role3);
                e.printStackTrace();
            }
        }
    }
}
