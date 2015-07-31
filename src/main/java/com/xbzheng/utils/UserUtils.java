package com.xbzheng.utils;

import com.xbzheng.common.security.shiro.realm.MysqlRealm.Principal;
import com.xbzheng.dao.IUserDao;
import com.xbzheng.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @Created by hun on 2015-07-21.
 */
public class UserUtils {

    private static final String CACHE_NAME = "userCache";
    private static final String USER_CACHE_ID_ = "user_id_";

    private static final IUserDao USERDAO = SpringContextHolder.getBean(IUserDao.class);
    /**
     * 通过登录名获取用户信息
     * @param loginName
     * @return
     */
    public static User getUserByLoginName(final String loginName){
        User user = (User)CacheUtils.get(CACHE_NAME, loginName);
        if(user == null){
            user = USERDAO.getUserByLoginName(loginName);
            if(user == null){
                return null;
            }

            CacheUtils.put(CACHE_NAME, USER_CACHE_ID_+user.getId(), user);
        }
        return user;
    }

    public static Session getSession(){
        final Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession(false);
        if(session == null){
            session = currentUser.getSession();
        }
        if(session != null){
            return session;
        }
        return null;
    }
    
    public static Principal getPrincipal(){
        try {
            Subject currentUser = SecurityUtils.getSubject();
            Principal principal = (Principal)currentUser.getPrincipal();
            if(principal != null) {
                return principal;
            }
        }catch (UnavailableSecurityManagerException e) {

        }catch (InvalidSessionException e){

        }
        return null;
    }
}
