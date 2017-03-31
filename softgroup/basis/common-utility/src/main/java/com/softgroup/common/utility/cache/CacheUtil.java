package com.softgroup.common.utility.cache;

import org.apache.commons.collections4.map.PassiveExpiringMap;

public class CacheUtil {

    public static final long TIME_TO_LIVE_MILLIS = 300_000;

    private static PassiveExpiringMap<String, Object> map =
                            new PassiveExpiringMap<>(TIME_TO_LIVE_MILLIS);

    public static void put(String key, Object value) {
        map.put(key, value);
    }

    public static Object get(String key) {
        return map.get(key);
    }

    public static boolean containsKey(String key) {
        return map.containsKey(key);
    }

    public static Object remove(String key) {
        return map.remove(key);
    }

    public static void clear() {
        map.clear();
    }
}