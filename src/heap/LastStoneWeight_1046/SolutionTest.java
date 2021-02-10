package heap.LastStoneWeight_1046;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.lastStoneWeight(new int[] {2, 7, 4, 1, 8, 1}));
    }
}