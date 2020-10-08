package design.TwoSum_III_DataStructureDesign_170;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {
    @Test
    public void test() {
        TwoSum t = new TwoSum();
        t.add(1);
        t.add(3);
        t.add(5);
        Assert.assertTrue(t.find(4));
        Assert.assertFalse(t.find(7));
    }
}
