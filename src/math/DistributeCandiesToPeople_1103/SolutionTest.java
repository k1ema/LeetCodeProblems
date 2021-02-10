package math.DistributeCandiesToPeople_1103;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {1, 2, 3, 1}, s.distributeCandies(7, 4));
        assertArrayEquals(new int[] {5, 2, 3}, s.distributeCandies(10, 3));
    }
}