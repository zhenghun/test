package com.xbzheng.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * ApplicationContextAware 主要作用就是获取ApplicationContext
 * DisposableBean的主要作用就是在bean销毁的时候做一些事情
 *
 * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候取出ApplicaitonContext.
 * Created by hun on 2015-07-21.
 */
@Service
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {
    private static final Logger LOG = LoggerFactory.getLogger(SpringContextHolder.class);
    private static ApplicationContext applicationContext = null;

    public static void cleanHolder(){
        if(LOG.isDebugEnabled()){
            LOG.debug("清除SpringContextHolder中的ApplicationContext:");
        }
        applicationContext = null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }


    /**
     * 实现DisposableBean接口，在context关闭的时候清除资源
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        SpringContextHolder.cleanHolder();
    }

    public static <T> T getBean(String name){
        checkApplicationContext();
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz){
        checkApplicationContext();
        return (T)applicationContext.getBean(clazz);
    }

    private static void checkApplicationContext(){
        if(applicationContext == null){
            throw new IllegalStateException("applicationContext未注入，请确认已经注入");
        }
    }
}
