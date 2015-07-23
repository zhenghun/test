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
 * ApplicationContextAware ��Ҫ���þ��ǻ�ȡApplicationContext
 * DisposableBean����Ҫ���þ�����bean���ٵ�ʱ����һЩ����
 *
 * �Ծ�̬��������Spring ApplicationContext, �����κδ����κεط��κ�ʱ��ȡ��ApplicaitonContext.
 * Created by hun on 2015-07-21.
 */
@Service
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {
    private static final Logger LOG = LoggerFactory.getLogger(SpringContextHolder.class);
    private static ApplicationContext applicationContext = null;

    public static void cleanHolder(){
        if(LOG.isDebugEnabled()){
            LOG.debug("���SpringContextHolder�е�ApplicationContext:");
        }
        applicationContext = null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }


    /**
     * ʵ��DisposableBean�ӿڣ���context�رյ�ʱ�������Դ
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
            throw new IllegalStateException("applicationContextδע�룬��ȷ���Ѿ�ע��");
        }
    }
}
