package test.impl;

import net.sf.ehcache.CacheManager;
import test.CacheWrapper;

/**
 * Created by Administrator on 2015/7/22.
 */
public class EhcacheWrapper<K, V> implements CacheWrapper<K, V> {
    private final String cacheName;
    private final CacheManager cacheManager;

    public EhcacheWrapper(final String cacheName, final CacheManager cacheManager){
        this.cacheManager = cacheManager;
        this.cacheName = cacheName;
    }

    @Override
    public void put(Object key, Object value) {

    }

    @Override
    public Object get(Object key) {
        return null;
    }
}
