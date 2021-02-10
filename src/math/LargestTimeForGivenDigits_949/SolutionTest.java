package math.LargestTimeForGivenDigits_949;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("23:41", s.largestTimeFromDigits(new int[] {1, 2, 3, 4}));
        assertEquals("", s.largestTimeFromDigits(new int[] {5, 5, 5, 5}));
        assertEquals("06:26", s.largestTimeFromDigits(new int[] {2, 0, 6, 6}));
    }
}