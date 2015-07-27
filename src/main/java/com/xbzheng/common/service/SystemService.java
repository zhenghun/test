package com.xbzheng.common.service;

import com.xbzheng.dao.IUserDao;
import com.xbzheng.model.User;
import com.xbzheng.utils.UserUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * InitializingBean�ӿڣ��ڳ�ʼ��bean��ʱ�����afterPropertiesSet���һЩ���׼��������
 * �������ú��������ļ�������init-method�������ơ���InitializingBean��afterPropertiesSet
 * ��������init-methodִ�У����afterPropertiesSet������ôinit-method������ִ�У�����
 * spring����bean��ʱ����ڲ������߼���
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
