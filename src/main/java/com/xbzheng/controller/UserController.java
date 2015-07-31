package com.xbzheng.controller;

import com.xbzheng.model.User;
import com.xbzheng.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @RequestMapping("findAll.do")
    public String findAllUser(final Model model){
        final List<User> userInfoList = userService.findAll(null);
        model.addAttribute("userInfoList", userInfoList);
        LOG.debug("Find all user info successfully!");
       // return "user/user-list";
        return ".user.list";
    }
}
