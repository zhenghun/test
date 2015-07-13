package com.xbzheng.controller;

import com.xbzheng.model.UserInfo;
import com.xbzheng.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2015/7/10.
 */
@Controller
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @RequestMapping("findAll.do")
    public String findAllUser(Model model){
        try{
            List<UserInfo> userInfoList = userService.findAll();
            model.addAttribute("userInfoList", userInfoList);
            LOG.debug("Find all user info successfully!");
        }catch (Exception e){
            LOG.debug(e.getMessage());
        }
       // return "user/user-list";
        return "userinfo.list";
    }
}
