package com.david.controller;

import com.david.entity.User;
import com.david.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by David
 * Project name: FuckingShiroRBAC1223
 * Created at 2019/12/23 22:24
 * Description: 用户行为
 *
 * loginDeal: 用户login页面ajax传入uA uP，认证，传回json msg，前端判断msg，成功跳转info，从info发动ajax，请求user对象
 * (后端不负责跳转页面，只负责返回json数据，跳转应由前端负责)
 */
@Controller
@RequestMapping({"user"})
public class UserController {

    @RequestMapping(path = {"loginDeal"}, method = {RequestMethod.GET, RequestMethod.POST}, params = {"uAccount","uPassword"}, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Map loginDeal(String uAccount, String uPassword, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println("loginDeal参数："+uAccount+" "+uPassword);
        //1.
        UsernamePasswordToken token = new UsernamePasswordToken(uAccount, uPassword);
        //2.
        Subject subject = SecurityUtils.getSubject();
        //3.
        Map map = new HashMap<>();
        try {
            subject.login(token);
            User user1 = (User) subject.getPrincipal();
            System.out.println("认证成功。");
            session.setAttribute("user", user1);
            map.put("msg", "认证成功");
            map.put("status", "ok");
            map.put("code", "200");
            //成功时给予提示并留在login界面
        } catch (AuthenticationException e) {
            System.err.println("认证失败！");
            map.put("msg", "认证失败");
            map.put("status", "error");
            map.put("code", "401");
        }
        return map;
    }

    @RequestMapping(path = {"infoMsg"}, method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Map infoMsg(HttpSession session) throws IOException {
        Map map = new HashMap();
        User user = (User) session.getAttribute("user");
        map.put("user", user);
        System.out.println("infoMsg用户："+user);
        map.put("status", "ok");
        map.put("code", "200");
        return map;
    }

    @RequestMapping(path = {"logout"})
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            return "index";
        }
    }

    @RequestMapping(path = {"getSessionUser"})
    @ResponseBody
    public User getSessionUser(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        User user = (User) session.getAttribute("user");
        return user;
    }

    @RequestMapping(path = {"registerDeal"}, method = {RequestMethod.GET, RequestMethod.POST}, params = {"uAccount","uPassword"})
    public String registerDeal(String uAccount, String uPassword){
        System.out.println(uAccount+" "+uPassword);
        return "register";
    }

}