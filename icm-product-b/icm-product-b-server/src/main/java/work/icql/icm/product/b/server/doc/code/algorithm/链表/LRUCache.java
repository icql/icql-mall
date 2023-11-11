package work.icql.icm.product.b.server.doc.code.algorithm.链表;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private LRU<Integer, Integer> lru;

    public LRUCache(int capacity) {
        lru = new LRU<>(capacity);
    }

    public int get(int key) {
        Integer result = lru.get(key);
        if (result == null) {
            return -1;
        }
        lru.put(key, lru.remove(key));
        return result;
    }

    public void put(int key, int value) {
        Integer result = lru.get(key);
        if (result == null) {
            lru.put(key, value);
            return;
        }
        lru.remove(key);
        lru.put(key, value);
    }

    private static class LRU<K, V> extends LinkedHashMap<K, V> {

        private int capacity;

        public LRU(int capacity) {
            super(capacity);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return super.size() > capacity;
        }
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(2, 1);
        obj.put(1, 1);
        obj.put(2, 3);
        obj.put(4, 1);
        obj.get(1);
        obj.get(2);

        System.out.println(obj);
    }
}
