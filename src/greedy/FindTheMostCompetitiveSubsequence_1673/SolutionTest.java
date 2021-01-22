package greedy.FindTheMostCompetitiveSubsequence_1673;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {2, 6}, s.mostCompetitive(new int[] {3, 5, 2, 6}, 2));
        assertArrayEquals(new int[] {2, 3, 3, 4}, s.mostCompetitive(new int[] {2, 4, 3, 3, 5, 4, 9, 6}, 4));
        assertArrayEquals(new int[] {3, 2, 6}, s.mostCompetitive(new int[] {3, 5, 2, 6}, 3));
        assertArrayEquals(new int[] {2, 3, 3, 4, 6}, s.mostCompetitive(new int[] {2, 4, 3, 3, 5, 4, 9, 6}, 5));
    }
}