package com.david.authentication;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

/**
 * Created by David
 * Project name: FuckingShiroRBAC1223
 * Created at 2019/12/24 14:39
 * Description:
 */
public class MyAuthentication {

    public void testAuth(){
        //1.
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        defaultSecurityManager.setRealm(iniRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //2.
        Subject subject = SecurityUtils.getSubject();

        //3.
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhangsan","fuck");
        UsernamePasswordToken usernamePasswordToken2 = new UsernamePasswordToken("david","123");

        //4.
        try {
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }

}
