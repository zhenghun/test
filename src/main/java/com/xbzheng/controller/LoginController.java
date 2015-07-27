package com.xbzheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hun on 2015-07-21.
 */
@Controller
public class LoginController {

    @RequestMapping("/sys/login")
    public String login(final Model model){
        return "";
    }


}
