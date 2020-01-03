package com.david.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by David
 * Project name: FuckingShiroRBAC1223
 * Created at 2019/12/23 22:29
 * Description:
 */

@Controller
@RequestMapping(path = {"role"})
public class RoleController {

    @RequestMapping(path = {"findRoles"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String findRoles(String uAccount, String uPassword){
        System.out.println(uAccount+" "+uPassword);
        return "register";
    }

}
