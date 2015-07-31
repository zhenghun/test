package com.xbzheng.controller;

import com.xbzheng.common.security.shiro.realm.MysqlRealm.Principal;
import com.xbzheng.utils.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping(value="/sys/login", method = RequestMethod.GET)
    public String login(final Model model){
        Principal principal = UserUtils.getPrincipal();
        if(principal != null ){
            return "redirect:/sys";
        }
        return "sysLogin";
    }


    @RequestMapping(value = "/sys/login", method = RequestMethod.POST)
    public String loginFail(final HttpServletRequest request, final HttpServletResponse response, final Model model){
        Principal principal = UserUtils.getPrincipal();
        if(principal != null){
            return "redirect:/sys";
        }
        return "/sysLogin";
    }

    @RequiresPermissions("user")
    @RequestMapping(value = "/sys")
    public String index(final HttpServletRequest request, final HttpServletResponse response){
        return ".user.list";
    }
}
