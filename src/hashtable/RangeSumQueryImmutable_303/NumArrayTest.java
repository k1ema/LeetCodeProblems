package hashtable.RangeSumQueryImmutable_303;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumArrayTest {
    @Test
    public void test() {
        NumArray n = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        assertEquals(1, n.sumRange(0, 2));
        assertEquals(-1, n.sumRange(2, 5));
        assertEquals(-3, n.sumRange(0, 5));
    }
}
