package com.xbzheng.common.security.shiro.realm;

import com.xbzheng.common.config.Global;
import com.xbzheng.common.security.shiro.token.UsernamePasswordToken;
import com.xbzheng.common.service.SystemService;
import com.xbzheng.model.User;
import com.xbzheng.servlet.ValidateCodeServlet;
import com.xbzheng.utils.SpringContextHolder;
import com.xbzheng.utils.UserUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/7/20.
 */
@Component
public class MysqlRealm  extends AuthorizingRealm{

    private SystemService systemService;
    /**
     * 进行授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 进行认证
     * @param authcToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

        Session session = UserUtils.getSession();
        String validateCode = (String)session.getAttribute(ValidateCodeServlet.VALIDATE_CODE);
        if(token.getValidateCode() != null || !token.getValidateCode().equals(validateCode)){
            throw new AuthenticationException("msg:验证码错误, 请重试.");
        }

        User user = systemService.getUserByLoginName(token.getUsername());
        if(user != null){
            if(Global.NO.equals(user.getLoginFlag())){
                throw new AuthenticationException("msg:该已帐号禁止登录.");
            }
            return SimpleAuthenticationInfo();
        }else{
            return null;
        }
        return null;
    }

    public static class Principal implements Serializable{
        private static final long serialVersionUID = 1L;

        private String id;
        private String name;
        private String loginName; // 登录名

        public Principal(User user){
            this.id = user.getId();
            this.loginName = user.getLoginName();
            this.name = user.getName();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }
    }

    public SystemService getSystemService(){
        if(systemService == null){
            systemService = SpringContextHolder.getBean(SystemService.class);
        }
        return systemService;
    }
}
