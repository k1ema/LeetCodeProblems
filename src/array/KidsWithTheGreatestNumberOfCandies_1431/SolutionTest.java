package array.KidsWithTheGreatestNumberOfCandies_1431;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(true, true, true, false, true), s.kidsWithCandies(new int[] {2, 3, 5, 1, 3}, 3));
        assertEquals(Arrays.asList(true, false, false, false, false), s.kidsWithCandies(new int[] {4, 2, 1, 1, 2}, 1));
        assertEquals(Arrays.asList(true, false, true), s.kidsWithCandies(new int[] {12, 1, 12}, 10));
    }
}