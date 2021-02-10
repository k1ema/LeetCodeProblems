package design.IteratorForCombination_1286;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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