package com.xbzheng.dao.user;

import com.xbzheng.model.UserInfo;

import java.util.List;

/**
 * Created by Administrator on 2015/7/9.
 */
public interface IUserDao {
    public List<UserInfo> findAll();

    public boolean insertUserInfo(UserInfo userInfo);
}
