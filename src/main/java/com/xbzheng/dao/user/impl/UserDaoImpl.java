package com.xbzheng.dao.user.impl;

import com.xbzheng.dao.user.IUserDao;
import com.xbzheng.model.UserInfo;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2015/7/9.
 */
@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    //private SqlSessionFactory sessionFactory;
    private SqlSessionTemplate sqlSession;

    public List<UserInfo> findAll(){
        return sqlSession.selectList("findAllUserInfo");
    }

    public boolean insertUserInfo(UserInfo userInfo) {
        sqlSession.insert("findAllUserInfo", userInfo);
        return false;
    }
}
