package com.organOld.oService.tool;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 基于ConcurrentHashMap实现带时限的缓存
 */
public class Cache {

    /**
     * 预缓存信息
     */
    private static final Map<String, Object> CACHE_MAP = new ConcurrentHashMap<String, Object>();

    /**
     * 每个缓存生效时间12小时
     */
    public static final long CACHE_HOLD_TIME_12H = 12 * 60 * 60 * 1000L;

    /**
     * 每个缓存生效时间24小时
     */
    public static final long CACHE_HOLD_TIME_24H = 24 * 60 * 60 * 1000L;

    /**
     * 存放一个缓存对象，默认不删除
     * @param cacheName
     * @param obj
     */
    public static boolean put(String cacheName, Object obj) {
        CACHE_MAP.put(cacheName, obj);
        return true;
    }

    /**
     * 存放一个缓存对象，保存时间为holdTime
     * @param cacheName
     * @param obj
     * @param holdTime
     */
    public static boolean put(String cacheName, Object obj, long holdTime) {
        CACHE_MAP.put(cacheName, obj);
        CACHE_MAP.put(cacheName + "_HoldTime", System.currentTimeMillis() + holdTime);//缓存失效时间
        return true;
    }

    /**
     * 取出一个缓存对象
     * @param cacheName
     * @return
     */
    public static Object get(String cacheName) {
        if (checkCacheName(cacheName)) {
            return CACHE_MAP.get(cacheName);
        }
        return null;
    }

    /**
     * 删除所有缓存
     */
    public static void removeAll() {
        CACHE_MAP.clear();
    }

    /**
     * 删除某个缓存
     * @param cacheName
     */
    public static void remove(String cacheName) {
        CACHE_MAP.remove(cacheName);
        CACHE_MAP.remove(cacheName + "_HoldTime");
    }

    /**
     * 检查缓存对象是否存在，
     * 若不存在，则返回false
     * 若存在，检查其是否已过有效期，如果已经过了则删除该缓存并返回false
     * @param cacheName
     * @return
     */
    public static boolean checkCacheName(String cacheName) {
        Long cacheHoldTime = (Long) CACHE_MAP.get(cacheName + "_HoldTime");
        if(cacheHoldTime == null)
            return false;
        if (cacheHoldTime < System.currentTimeMillis()) {
            remove(cacheName);
            return false;
        }
        return true;
    }
}
