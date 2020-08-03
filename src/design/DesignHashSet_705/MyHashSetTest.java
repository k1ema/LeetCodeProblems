package design.DesignHashSet_705;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashSetTest {
    @Test
    public void test() {
        MyHashSet s = new MyHashSet();
        s.add(1);
        s.add(2);
        assertTrue(s.contains(1));
        assertFalse(s.contains(3));
        s.add(2);
        assertTrue(s.contains(2));
        s.remove(2);
        assertFalse(s.contains(2));
    }

    @Test
    public void testBST() {
        MyHashSetBST s = new MyHashSetBST();
        s.add(1);
        s.add(2);
        assertTrue(s.contains(1));
        assertFalse(s.contains(3));
        s.add(2);
        assertTrue(s.contains(2));
        s.remove(2);
        assertFalse(s.contains(2));
    }
}