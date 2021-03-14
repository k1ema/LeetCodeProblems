package segmentTree.RangeSumQuery_Mutable_307;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumArrayTest {
    @Test
    public void test() {
        NumArray n = new NumArray(new int[] {1, 3, 5});
        assertEquals(9, n.sumRange(0, 2));
        n.update(1, 2);
        assertEquals(8, n.sumRange(0, 2));
    }
}
