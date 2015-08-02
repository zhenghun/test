package com.xbzheng.common.service;

import com.xbzheng.model.User;
import com.xbzheng.utils.Digests;
import com.xbzheng.utils.Encodes;
import com.xbzheng.utils.UserUtils;
import org.springframework.beans.factory.InitializingBean;
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

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int SALT_SIZE = 8;
    public static final int HASH_TIMES = 1024;

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

    public static boolean validatePassword(String plainPassword, String password){
        byte[] salt = Encodes.decodeHex(password.substring(0, 16));
        byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_TIMES);
        return password.equals(Encodes.encodeHex(salt)+Encodes.encodeHex(hashPassword));
    }

    public static void main(String[] args){
        //System.out.println(encryptPassword("zhenghun"));
        String password = "94822f696162754498d05a5bc23813b92ca29bb89d6f8ad4ba8388cf";
        String planPassword = "zhenghun";
        System.out.println(validatePassword(planPassword, password));;
    }
}
