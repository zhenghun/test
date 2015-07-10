package com.xbzheng.controller;

import com.xbzheng.model.UserInfo;
import com.xbzheng.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2015/7/10.
 */
@Controller
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @RequestMapping("findAll.do")
    public String findAllUser(){
        try{
            userService.findAll();
            UserInfo userInfo = new UserInfo();
            userInfo.setId(2);
            userInfo.setPassword("123");
            userInfo.setUsername("zheng");
            userService.insertUserInfo(userInfo);
            LOG.debug("Find all user info successfully!");
        }catch (Exception e){
            LOG.debug(e.getMessage());
        }
        return "user/user-list";
    }
}
