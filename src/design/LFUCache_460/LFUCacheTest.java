package design.LFUCache_460;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LFUCacheTest {
    @Test
    public void test() {
        LFUCache c = new LFUCache(2);
        c.put(1, 1);
        c.put(2, 2);
        assertEquals(1, c.get(1));
        c.put(3, 3);
        assertEquals(-1, c.get(2));
        assertEquals(3, c.get(3));
        c.put(4, 4);
        assertEquals(-1, c.get(1));
        assertEquals(3, c.get(3));
        assertEquals(4, c.get(4));

        c = new LFUCache(0);
        c.put(0, 0);
        assertEquals(-1, c.get(0));
    }
}