package com.xbzheng.common.service;

import com.xbzheng.dao.IUserDao;
import com.xbzheng.model.User;
import com.xbzheng.utils.Digests;
import com.xbzheng.utils.Encodes;
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

    private static final int SALT_SIZE = 8;
    private static final int HASH_TIMES = 1024;

    public User getUserByLoginName(final String userName) {
        return UserUtils.getUserByLoginName(userName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    public static String encryptPassword(final String plainPassword){
        final byte[] salt = Digests.getSalt(SALT_SIZE);
        final byte[] hasePassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_TIMES);
        return Encodes.encodeHex(salt)+Encodes.encodeHex(hasePassword);
    }

    public static void main(String[] args){
        System.out.println(encryptPassword("zhenghun"));
    }
}
