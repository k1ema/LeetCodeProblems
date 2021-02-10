package greedy.CorporateFlightBookings_1109;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {10, 55, 45, 25, 25}, s.corpFlightBookings(new int[][] {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5));
    }
}