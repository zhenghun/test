package com.xbzheng.common.security.shiro.token;

import com.xbzheng.utils.StringUtilsCustom;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 表单验证过滤类
 * @Created by Administrator on 2015/7/30.
 */
@Service
public class FormAuthenticationFilterCustom extends FormAuthenticationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormAuthenticationFilterCustom.class);

    @Override
    protected AuthenticationToken createToken(final ServletRequest request, final ServletResponse response) {
        final String username = getUsername(request);
        String password = getPassword(request);
        if(password == null){
            password = "";
        }
        final boolean rememberMe = isRememberMe(request);
        final String host = StringUtilsCustom.getRemoteAddr((HttpServletRequest) request);
        final String captcha = getCaptcha(request);
        return new UsernamePasswordTokenCustom(username, password.toCharArray(),rememberMe, host,captcha);
    }

    @Override
    public String getSuccessUrl(){
        return super.getSuccessUrl();
    }

    /**
     * 登录成功跳转
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    protected void issueSuccessRedirect(final ServletRequest request, final ServletResponse response) throws Exception {
        //super.issueSuccessRedirect(request, response);
        WebUtils.issueRedirect(request,response, getSuccessUrl(), null, true);
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        if(!"XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"))|| req.getParameter("ajax") == null){
            res.sendRedirect(req.getContextPath()+this.getSuccessUrl());
        }else{
            res.sendRedirect(req.getContextPath()+"/sys/login");
        }
        return false;
    }

    /**
     * 登录失败，消息处理
     * @param token
     * @param e
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean onLoginFailure(final AuthenticationToken token, final AuthenticationException e, final ServletRequest request, final ServletResponse response) {
        final String className = e.getClass().getName();
        String message = "";
        if(IncorrectCredentialsException.class.getName().equals(className) || UnknownAccountException.class.getName().equals(className)){
            message = "用户或密码错误, 请重试.";
        }else if(e.getMessage() != null && StringUtils.startsWith(e.getMessage(),"msg:")){
            message = StringUtils.replace(e.getMessage(), "msg:", "");
        }else{
            message = "系统出现点问题，请稍后再试！";
            LOGGER.error("LOGIN ERROR MESSAGE:", e);
        }
        request.setAttribute("shiroLoginFailure", className);
        request.setAttribute("message", message);
        return true;
    }

    protected String getCaptcha(final ServletRequest request){
        return WebUtils.getCleanParam(request, "validateCode");
    }
}
