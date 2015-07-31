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
     * ɾ���û���ɫ
     * @param user
     * @return
     */
    public int deleteUserRole(User user);

    /**
     * �����û���ɫ
     * @param user
     * @return
     */
    public int insertUserRole(User user);

    /**
     * �����û���Ϣ
     * @param user
     * @return
     */
    public int updateUserInfo(User user);
}
