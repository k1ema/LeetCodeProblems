package design.BinarySearchTreeIterator_173;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BSTIteratorTest {
    @Test
    public void test() {
        BSTIterator s = new BSTIterator(tree.utils.Parser.stringToTreeNode("[7,3,15,1,4,10,20]"));
        Assert.assertEquals(1, s.next());
        Assert.assertEquals(3, s.next());
        Assert.assertEquals(4, s.next());
        assertTrue(s.hasNext());
        Assert.assertEquals(7, s.next());
        Assert.assertEquals(10, s.next());
        assertTrue(s.hasNext());
        Assert.assertEquals(15, s.next());
        Assert.assertEquals(20, s.next());
        assertFalse(s.hasNext());
    }
}