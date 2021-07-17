package array.RangeSumQuery2DImmutable_304;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumMatrixTest {
    @Test
    public void test() {
        NumMatrix nm = new NumMatrix(new int[][] {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        assertEquals(8, nm.sumRegion(2, 1, 4, 3));
        assertEquals(11, nm.sumRegion(1, 1, 2, 2));
        assertEquals(12, nm.sumRegion(1, 2, 2, 4));
    }
}
