package design.IteratorForCombination_1286;

import org.junit.Test;

import static org.junit.Assert.*;

public class CombinationIteratorTest {
    @Test
    public void test() {
        CombinationIterator c = new CombinationIterator("abc", 2);
        assertEquals("ab", c.next());
        assertTrue(c.hasNext());
        assertEquals("ac", c.next());
        assertTrue(c.hasNext());
        assertEquals("bc", c.next());
        assertFalse(c.hasNext());
    }
}