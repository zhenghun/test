package com.xbzheng.service.impl;

import com.xbzheng.dao.IUserDao;
import com.xbzheng.model.User;
import com.xbzheng.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by Administrator on 2015/7/10.
 */
@Service
public class UserServiceImpl implements IUserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private IUserDao<User> userDao;

    @Override
    public List<User> findAll(final User user) {
        return userDao.findAllList(user);
    }
}
