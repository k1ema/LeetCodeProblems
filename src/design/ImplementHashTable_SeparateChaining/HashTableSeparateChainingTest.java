package design.ImplementHashTable_SeparateChaining;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HashTableSeparateChainingTest {
    @Test
    public void test() {
        HashTableSeparateChaining<String, Integer> ht = new HashTableSeparateChaining<>();
        ht.put("a", 1);
        ht.put("b", 2);
        ht.put("c", 3);
        ht.put("d", 4);
        ht.put("aa", 4); // hash same as "a"
        assertEquals(1, (int) ht.get("a"));
        assertEquals(2, (int) ht.get("b"));
        assertEquals(3, (int) ht.get("c"));
        assertEquals(4, (int) ht.get("d"));
        assertEquals(4, (int) ht.get("aa"));
        ht.put("aa", 5);
        assertEquals(5, (int) ht.get("aa"));
        ht.put("aaa", 6); // hash same as "a" and "aa"
        ht.remove("aaa");
        assertNull(ht.get("aaa"));
        ht.remove("b");
        assertNull(ht.get("b"));

        HashTableSeparateChaining<Integer, String> map = new HashTableSeparateChaining<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(98, "98");
        map.put(195, "195");
        assertEquals("1", map.get(1));
        assertEquals("2", map.get(2));
        assertEquals("3", map.get(3));
        assertEquals("98", map.get(98));
        assertEquals("195", map.get(195));
        map.remove(98);
        assertNull(map.get(98));
        assertEquals("1", map.get(1));
        assertEquals("195", map.get(195));
    }
}