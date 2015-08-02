package com.xbzheng.common.service;

import com.xbzheng.model.User;
import com.xbzheng.utils.Digests;
import com.xbzheng.utils.Encodes;
import com.xbzheng.utils.UserUtils;
import org.springframework.beans.factory.InitializingBean;
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
