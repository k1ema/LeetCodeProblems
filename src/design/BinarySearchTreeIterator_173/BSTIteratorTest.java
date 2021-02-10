package design.BinarySearchTreeIterator_173;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BSTIteratorTest {
    @Test
    public void test() {
        BSTIterator s = new BSTIterator(tree.utils.Parser.stringToTreeNode("[7,3,15,1,4,10,20]"));
        assertEquals(1, s.next());
        assertEquals(3, s.next());
        assertEquals(4, s.next());
        assertTrue(s.hasNext());
        assertEquals(7, s.next());
        assertEquals(10, s.next());
        assertTrue(s.hasNext());
        assertEquals(15, s.next());
        assertEquals(20, s.next());
        assertFalse(s.hasNext());
    }
}