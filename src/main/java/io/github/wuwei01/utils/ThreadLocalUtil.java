package io.github.wuwei01.utils;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalUtil {

    private static final ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal() {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>(4);
        }
    };

    public static Map<String, Object> getThreadLocal() {
        return threadLocal.get();
    }

    public static Object get(String key) {
        return getThreadLocal().get(key);
    }

    public static void set(String key, Object value) {
        getThreadLocal().put(key, value);
    }

    public static Object remove(String key) {
        return getThreadLocal().remove(key);
    }
}