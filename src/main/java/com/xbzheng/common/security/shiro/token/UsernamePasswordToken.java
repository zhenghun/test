package com.xbzheng.common.security.shiro.token;

/**
 * Created by hun on 2015-07-21.
 */
public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {
    private String validateCode;

    public UsernamePasswordToken(){
        super();
    }

    public UsernamePasswordToken(String username, char[] password, boolean rememberMe, String host, String validateCode){
        super(username,password,rememberMe,host);
        this.validateCode = validateCode;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }
}
