package com.xbzheng.dao;

import com.xbzheng.common.persistence.ICrudDao;
import com.xbzheng.common.persistence.annotation.MyBatisDao;
import com.xbzheng.model.User;
import org.springframework.stereotype.Repository;

/**
 * @Created by hun on 2015-07-23.
 */
@Repository
public interface IUserDao<T> extends ICrudDao<User> {

    public User getUserByLoginName(String name);

    public int updatePasswordById(User user);

    public int updateLoginInfo(User user);

    /**
     * 删除用户角色
     * @param user
     * @return
     */
    public int deleteUserRole(User user);

    /**
     * 增加用户角色
     * @param user
     * @return
     */
    public int insertUserRole(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public int updateUserInfo(User user);
}
