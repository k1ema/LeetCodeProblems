package design.TwoSum_III_DataStructureDesign_170;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwoSumTest {
    @Test
    public void test() {
        TwoSum t = new TwoSum();
        t.add(1);
        t.add(3);
        t.add(5);
        assertTrue(t.find(4));
        assertFalse(t.find(7));
    }
}
