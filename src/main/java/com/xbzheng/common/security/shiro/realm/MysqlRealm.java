package com.xbzheng.common.security.shiro.realm;

import com.xbzheng.common.config.Global;
import com.xbzheng.common.security.shiro.token.UsernamePasswordTokenCustom;
import com.xbzheng.common.service.SystemService;
import com.xbzheng.model.User;
import com.xbzheng.servlet.ValidateCodeServlet;
import com.xbzheng.utils.Encodes;
import com.xbzheng.utils.SpringContextHolder;
import com.xbzheng.utils.UserUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class MysqlRealm  extends AuthorizingRealm{

    @Autowired
    private SystemService systemService;
    /**
     * ������Ȩ
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(final PrincipalCollection principals) {
        final SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("user");
        return info;
    }

    /**
     * ������֤
     * @param authcToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(final AuthenticationToken authcToken) {
        final UsernamePasswordTokenCustom token = (UsernamePasswordTokenCustom) authcToken;

        final Session session = UserUtils.getSession();
        final String validateCode = (String)session.getAttribute(ValidateCodeServlet.VALIDATE_CODE);
        if(token.getValidateCode() == null || !token.getValidateCode().equalsIgnoreCase(validateCode)){
            throw new AuthenticationException("msg:��֤�����, ������.");
        }

        final User user = systemService.getUserByLoginName(token.getUsername());
        if(user != null){
            if(Global.NO.equals(user.getLoginFlag())){
                throw new AuthenticationException("msg:�����ʺŽ�ֹ��¼.");
            }
            final byte[] salt = Encodes.decodeHex(user.getPassword().substring(0, 16));
            return new SimpleAuthenticationInfo(new Principal(user),user.getPassword().substring(16), ByteSource.Util.bytes(salt), getName());
        }
        return null;
    }

    public static class Principal implements Serializable{
        private static final long serialVersionUID = 1L;

        private String id;
        private String userName;
        private String loginName; // ��¼��

        public Principal(final User user){
            this.id = user.getId();
            this.loginName = user.getLoginName();
            this.userName = user.getUserName();
        }

        public String getId() {
            return id;
        }

        public void setId(final String id) {
            this.id = id;
        }

        public String getName() {
            return userName;
        }

        public void setName(final String name) {
            this.userName = name;
        }

        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(final String loginName) {
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
