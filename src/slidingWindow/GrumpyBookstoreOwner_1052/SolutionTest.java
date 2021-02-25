package slidingWindow.GrumpyBookstoreOwner_1052;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(16, s.maxSatisfied(new int[] {1, 0, 1, 2, 1, 1, 7, 5}, new int[] {0, 1, 0, 1, 0, 1, 0, 1}, 3));
    }
}