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

/**
 * Created by Administrator on 2015/7/20.
 */
@Component
public class MysqlRealm  extends AuthorizingRealm{

    private SystemService systemService;
    /**
     * ������Ȩ
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * ������֤
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
            throw new AuthenticationException("msg:��֤�����, ������.");
        }

        User user = systemService.getUserByLoginName(token.getUsername());
        if(user != null){
            if(Global.NO.equals(user.getLoginFlag())){
                throw new AuthenticationException("msg:�����ʺŽ�ֹ��¼.");
            }
            return SimpleAuthenticationInfo(new Principal());
        }else{
            return null;
        }
        return null;
    }


    public SystemService getSystemService(){
        if(systemService == null){
            systemService = SpringContextHolder.getBean(SystemService.class);
        }
        return systemService;
    }
}
