package dynamic.NumberOfSubmatricesThatSumToTarget_1074;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.numSubmatrixSumTarget(new int[][] {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}, 0));
        assertEquals(5, s.numSubmatrixSumTarget(new int[][] {{1, -1}, {-1, 1}}, 0));
        assertEquals(0, s.numSubmatrixSumTarget(new int[][] {{904}}, 0));
    }
}