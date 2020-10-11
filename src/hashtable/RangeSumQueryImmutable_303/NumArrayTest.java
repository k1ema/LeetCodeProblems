package hashtable.RangeSumQueryImmutable_303;

import org.junit.Assert;
import org.junit.Test;

public class NumArrayTest {
    @Test
    public void test() {
        NumArray n = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        Assert.assertEquals(1, n.sumRange(0, 2));
        Assert.assertEquals(-1, n.sumRange(2, 5));
        Assert.assertEquals(-3, n.sumRange(0, 5));
    }
}
