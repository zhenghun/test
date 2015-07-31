package com.xbzheng.common.security.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UsernamePasswordTokenCustom extends UsernamePasswordToken {
    private static final long serialVersionUID = 1L;

    private String validateCode;

    public UsernamePasswordTokenCustom(){
        super();
    }

    public UsernamePasswordTokenCustom(final String username, final char[] password, final boolean rememberMe, final String host, final String validateCode){
        super(username,password,rememberMe,host);
        this.validateCode = validateCode;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(final String validateCode) {
        this.validateCode = validateCode;
    }
}
