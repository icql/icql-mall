package work.icql.icm.product.b.server.infra.context;

import lombok.Getter;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class AppContext {

    @Getter
    public enum Key {

        REQUEST_ID("requestId"),
        UID("uid"),
        IP("ip");

        private final String key;

        Key(String key) {
            this.key = key;
        }
    }

    private AppContext() {
    }

    private static final InheritableThreadLocal<Map<Key, Object>> threadLocal
            = new InheritableThreadLocal<Map<Key, Object>>() {
        protected Map<Key, Object> childValue(Map<Key, Object> parentValue) {
            return parentValue == null ? null : new ConcurrentHashMap<>(parentValue);
        }
    };

    public static Object get(Key key) {
        if (Objects.isNull(key)) {
            return null;
        }
        Map<Key, Object> objectMap = threadLocal.get();
        if (Objects.isNull(objectMap)) {
            return null;
        }
        return objectMap.get(key);
    }

    public static void put(Key key, Object value) {
        if (Objects.isNull(key) || Objects.isNull(value)) {
            return;
        }
        Map<Key, Object> objectMap = threadLocal.get();
        if (Objects.isNull(objectMap)) {
            objectMap = new ConcurrentHashMap<>();
            threadLocal.set(objectMap);
        }
        objectMap.put(key, value);
    }


    public static void remove(Key key) {
        if (Objects.isNull(key)) {
            return;
        }
        Map<Key, Object> objectMap = threadLocal.get();
        if (Objects.nonNull(objectMap)) {
            objectMap.remove(key);
        }
    }

    public static void clear() {
        threadLocal.remove();
    }

    public static Map<Key, Object> getMap() {
        return threadLocal.get();
    }

    public static String requestId() {
        Object value = get(Key.REQUEST_ID);
        if (Objects.isNull(value)) {
            return "";
        }
        return value.toString();
    }

    public static long uid() {
        Object value = get(Key.UID);
        if (Objects.isNull(value)) {
            return 0L;
        }
        return Long.parseLong(value.toString());
    }

    public static String ip() {
        Object value = get(Key.IP);
        if (Objects.isNull(value)) {
            return "";
        }
        return value.toString();
    }
}
