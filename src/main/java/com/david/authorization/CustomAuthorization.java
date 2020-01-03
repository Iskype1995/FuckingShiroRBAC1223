package com.david.authorization;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomAuthorization {
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
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:custom.ini");
        SecurityManager securityManager = iniSecurityManagerFactory.getInstance();
        //3.
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        //4.
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //5.
        try {
            subject.login(token);
            System.out.println("认证成功！");
        } catch (AuthenticationException e) {
            System.err.println("肏他妈的，认证失败了！！");
            e.printStackTrace();
        } finally {
        }
        //6.
        if(subject.isAuthenticated()){
            // todo 认证通过时进行授权
            //6-1.检查角色：
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
            //
            System.out.println("开始授权，请输入3个角色！");
            String role1 = sc.nextLine();
            String role2 = sc.nextLine();
            String role3 = sc.nextLine();
            try {
                subject.checkRoles(role1, role2, role3);
                System.out.println("用户拥有角色："+role1+role2+role3);
            } catch (AuthorizationException e) {
                System.err.println("用户不拥有角色："+role1+role2+role3);
                e.printStackTrace();
            }
            //6-2.检查权限：
            System.out.println("请输入3个权限：");
            String permission1 = sc.nextLine();
            String permission2 = sc.nextLine();
            String permission3 = sc.nextLine();
            try {
                subject.checkPermission(permission1);
                subject.checkPermission(permission2);
                subject.checkPermission(permission3);
                subject.checkPermissions(permission1, permission2, permission3);
                System.out.println("用户拥有权限："+permission1+permission2+permission3);
            } catch (AuthorizationException e) {
                System.err.println("用户不拥有权限："+permission1+permission2+permission3);
                e.printStackTrace();
            }
            System.out.println("请输入3个权限：");
            String permission4 = sc.nextLine();
            String permission5 = sc.nextLine();
            String permission6 = sc.nextLine();
            boolean isPermittedOne = subject.isPermitted(permission4);
            System.out.println("拥有权限: "+permission4+" :"+isPermittedOne);

            boolean isPermittedAll = subject.isPermittedAll(permission4, permission5, permission6);
            System.out.println("拥有权限: "+permission4+permission5+permission6+" :"+isPermittedAll);

            boolean[] isPermitted = subject.isPermitted(permission4,permission5,permission6);
            for(int i=0;i<isPermitted.length;i++){
                System.out.println("拥有第"+(i+1)+"个权限: "+isPermitted[i]);
            }
        }
    }
}
