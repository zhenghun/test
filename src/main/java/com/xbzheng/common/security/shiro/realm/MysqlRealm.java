package com.xbzheng.common.security.shiro.realm;

import com.xbzheng.common.security.shiro.token.UsernamePasswordToken;
import com.xbzheng.servlet.ValidateCodeServlet;
import com.xbzheng.utils.UserUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
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
        return null;
    }
}
