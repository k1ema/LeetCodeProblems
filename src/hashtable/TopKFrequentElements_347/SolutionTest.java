package hashtable.TopKFrequentElements_347;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {1, 2}, s.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2));
        assertArrayEquals(new int[] {1}, s.topKFrequent(new int[] {1}, 1));
        assertArrayEquals(new int[] {0}, s.topKFrequent(new int[] {3, 0, 1, 0}, 1));
        assertArrayEquals(new int[] {1, 2}, s.topKFrequent(new int[] {1, 2}, 2));
        assertArrayEquals(new int[] {-1, 2}, s.topKFrequent(new int[] {4, 1, -1, 2, -1, 2, 3}, 2));
    }
}
