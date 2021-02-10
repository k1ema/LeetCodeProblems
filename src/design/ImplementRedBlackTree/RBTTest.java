package design.ImplementRedBlackTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RBTTest {
    @Test
    public void test() {
        LeanLeftRedBlackTree<Integer, String> rbt = new LeanLeftRedBlackTree<>();
        rbt.put(6, "A");
        rbt.put(3, "B");
        rbt.put(5, "C");
        rbt.put(8, "D");
        rbt.put(2, "E");
        rbt.put(4, "F");
        rbt.put(9, "G");
        rbt.put(1, "X");
        assertEquals("D", rbt.get(8));
        assertEquals("F", rbt.get(4));
        assertEquals("G", rbt.max());
        assertEquals("X", rbt.min());
        assertFalse(rbt.isEmpty());
        assertEquals(8, rbt.size());

        for (int k : rbt.keys()) {
            System.out.println(k + "->" + rbt.get(k));
        }
        assertTrue(rbt.contains(9));
        assertFalse(rbt.contains(10));
    }
}
