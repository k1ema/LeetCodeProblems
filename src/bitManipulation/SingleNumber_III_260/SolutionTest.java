package bitManipulation.SingleNumber_III_260;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {5, 3}, s.singleNumber(new int[] {1, 2, 1, 3, 2, 5}));
    }
}
