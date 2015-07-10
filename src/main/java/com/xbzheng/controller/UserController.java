package com.xbzheng.controller;

import com.xbzheng.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2015/7/10.
 */
@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("findAll.do")
    public String findAllUser(){
        userService.findAll();
        return "user/user-list";
    }
}
