package com.xbzheng.service;

import com.xbzheng.model.User;

import java.util.List;

/**
 * Created by Administrator on 2015/7/10.
 */
public interface IUserService {
    public List<User> findAll();
    public boolean insertUserInfo(User userInfo);
}
