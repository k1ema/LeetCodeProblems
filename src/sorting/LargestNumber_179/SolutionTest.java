package sorting.LargestNumber_179;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("210", s.largestNumber(new int[] {10, 2}));
        assertEquals("9534330", s.largestNumber(new int[] {3, 30, 34, 5, 9}));
        assertEquals("0", s.largestNumber(new int[] {0, 0, 0, 0, 0, 0}));
        assertEquals("100000", s.largestNumber(new int[] {0, 0, 1, 0, 0, 0}));
    }
}