package hashtable.MaxNumberOfKSumPairs_1679;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.maxOperations(new int[] {1, 2, 3, 4}, 5));
        assertEquals(1, s.maxOperations(new int[] {3, 1, 3, 4, 3}, 6));
        assertEquals(4, s.maxOperations(new int[] {2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2}, 3));
    }
}