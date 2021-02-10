package dynamic.FormLargestIntegerWithDigitsThatAddUpToTarget_1449;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("7772", s.largestNumber(new int[] {4, 3, 2, 5, 6, 7, 2, 5, 5}, 9));
        assertEquals("85", s.largestNumber(new int[] {7, 6, 5, 5, 5, 6, 8, 7, 8}, 12));
        assertEquals("0", s.largestNumber(new int[] {2, 4, 6, 2, 4, 6, 4, 4, 4}, 5));
        assertEquals("32211", s.largestNumber(new int[] {6, 10, 15, 40, 40, 40, 40, 40, 40}, 47));
    }
}