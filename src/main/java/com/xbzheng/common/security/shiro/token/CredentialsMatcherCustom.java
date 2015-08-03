package com.xbzheng.common.security.shiro.token;

import com.xbzheng.common.service.SystemService;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @Created by Administrator on 2015/8/3.
 */
public class CredentialsMatcherCustom extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(final AuthenticationToken token, final AuthenticationInfo info) {
        final UsernamePasswordTokenCustom cToken = (UsernamePasswordTokenCustom) token;
        final String plainPassword = new String(cToken.getPassword());
        final String password = (String)info.getCredentials();
        return SystemService.validatePassword(plainPassword, password);
    }
}
