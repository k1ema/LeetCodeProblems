package greedy.AdvantageShuffle_870;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {2, 11, 7, 15}, s.advantageCount(new int[] {2, 7, 11, 15}, new int[] {1, 10, 4, 11}));
        assertArrayEquals(new int[] {24, 32, 8, 12}, s.advantageCount(new int[] {12, 24, 8, 32}, new int[] {13, 25, 32, 11}));
    }
}