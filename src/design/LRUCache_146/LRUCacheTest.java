package design.LRUCache_146;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUCacheTest {
    @Test
    public void test() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));     // returns 1
        cache.put(3, 3);                            // evicts key 2
        assertEquals(-1, cache.get(2));    // returns -1 (not found)
        cache.put(4, 4);                            // evicts key 1
        assertEquals(-1, cache.get(1));    // returns -1 (not found)
        assertEquals(3, cache.get(3));     // returns 3
        assertEquals(4, cache.get(4));     // returns 4

        cache = new LRUCache(2);
        assertEquals(-1, cache.get(2));
        cache.put(2, 6);
        assertEquals(-1, cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        assertEquals(2, cache.get(1));
        assertEquals(6, cache.get(2));

        cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(2));

        cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        assertEquals(4, cache.get(4));
        assertEquals(3, cache.get(3));
        assertEquals(2, cache.get(2));
        assertEquals(-1, cache.get(1));
        cache.put(5, 5);
        assertEquals(-1, cache.get(1));
        assertEquals(2, cache.get(2));
        assertEquals(3, cache.get(3));
        assertEquals(-1, cache.get(4));
        assertEquals(5, cache.get(5));

        cache = new LRUCache(1);
        cache.put(2, 1);
        assertEquals(1, cache.get(2));
        cache.put(3, 2);
        assertEquals(-1, cache.get(2));
        assertEquals(2, cache.get(3));
    }
}
