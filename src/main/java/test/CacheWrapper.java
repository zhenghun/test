package test;

/**
 * Created by Administrator on 2015/7/22.
 */
public interface CacheWrapper<K, V> {
    void put(K key, V value);
    V get(K key);
}
