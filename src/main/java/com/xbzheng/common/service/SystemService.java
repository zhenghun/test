package com.xbzheng.common.service;

import com.xbzheng.dao.IUserDao;
import com.xbzheng.model.User;
import com.xbzheng.utils.UserUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * InitializingBean接口，在初始化bean的时候调用afterPropertiesSet完成一些相关准备工作，
 * 它的作用和在配置文件中配置init-method属性类似。且InitializingBean的afterPropertiesSet
 * 方法先于init-method执行，如果afterPropertiesSet出错，那么init-method将不会执行，这是
 * spring加载bean的时候的内部处理逻辑。
 *
 *
 * Created by hun on 2015-07-26.
 */
@Service
public class SystemService extends BaseService implements InitializingBean {

    @Autowired
    private IUserDao userDao;

    public User getUserByLoginName(String userName){
        return UserUtils.getUserByLoginName(userName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
