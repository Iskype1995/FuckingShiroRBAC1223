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
@RequestMapping(path = {"permission"})
public class PermissionController {

    @RequestMapping(path = {"403"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String Error403(){
        return "403";
    }

    @RequestMapping(path = {"adultvideo"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String adultVideo(){
        return "permission/adultvideo";
    }

    @RequestMapping(path = {"annopage"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String annoPage(){
        return "permission/annopage";
    }

    @RequestMapping(path = {"reception"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String reception(){
        return "permission/reception";
    }

    @RequestMapping(path = {"safeguard"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String safeguard(){
        return "permission/safeguard";
    }

    @RequestMapping(path = {"carmanagement"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String carManagement(){
        return "permission/carmanagement";
    }

    @RequestMapping(path = {"police"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String police(){
        return "permission/police";
    }

    @RequestMapping(path = {"humanresource"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String humanResource(){
        return "permission/humanresource";
    }

    @RequestMapping(path = {"humanmanagement"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String humanManagement(){
        return "permission/humanmanagement";
    }

    @RequestMapping(path = {"salary"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String salary(){
        return "permission/salary";
    }

    @RequestMapping(path = {"cleaner"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String cleaner(){
        return "permission/cleaner";
    }

    @RequestMapping(path = {"gymmanagement"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String gymmanagement(){
        return "permission/gymmanagement";
    }

    @RequestMapping(path = {"devops"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String devOps(){
        return "permission/devops";
    }

    @RequestMapping(path = {"development"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String development(){
        return "permission/development";
    }

    @RequestMapping(path = {"requirement"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String requirement(){
        return "permission/requirement";
    }

    @RequestMapping(path = {"meeting"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String meeting(){
        return "permission/meeting";
    }

    @RequestMapping(path = {"secretary"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String secretary(){
        return "permission/secretary";
    }
}
