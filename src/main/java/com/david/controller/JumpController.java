package com.david.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by David
 * Project name: FuckingShiroRBAC1223
 * Created at 2019/12/23 21:42
 * Description: 跳转控制器
 */

@Controller
@RequestMapping({"jump"})
public class JumpController {

    @RequestMapping(path = {"indexUI"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String indexUI(){
        return "index";
    }

    @RequestMapping(path = {"loginUI"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String loginUI(){
        return "login";
    }

    @RequestMapping(path = {"registerUI"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String registerUI(){
        return "register";
    }

    @RequestMapping(path = {"infoUI"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String infoUI(){
        return "info";
    }

}
