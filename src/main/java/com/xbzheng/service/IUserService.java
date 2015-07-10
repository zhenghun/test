package com.xbzheng.service;

import com.xbzheng.model.UserInfo;

import java.util.List;

/**
 * Created by Administrator on 2015/7/10.
 */
public interface IUserService {
    public List<UserInfo> findAll();
    public boolean insertUserInfo(UserInfo userInfo);
}
