package com.xbzheng.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hun on 2015-07-21.
 */
public class CacheUtils {
    private static final Logger LOG = LoggerFactory.getLogger(CacheUtils.class);

    private static CacheManager cacheManager = SpringContextHolder.getBean("cacheManager");


    /**
     * 写入缓存
     * @param cacheName   ehcache-local.xml  配置文件中配置的cache的名字
     * @param key
     * @param value
     */
    public static void put(String cacheName, String key, Object value){
        getCache(cacheName).put(new Element(key, value));
    }

    /**
     * 获取缓存
     * @param cacheName
     * @param key
     * @return
     */
    public static Object get(String cacheName, String key){
        return getCache(cacheName).get(key);
    }

    public static void remove(String cacheName, String key){
        getCache(cacheName).remove(key);
    }

    public static Cache getCache(String cacheName){
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null){
            cacheManager.addCache(cacheName);
            cache = cacheManager.getCache(cacheName);
            cache.getCacheConfiguration().setEternal(true);
        }
        return cache;
    }
}
