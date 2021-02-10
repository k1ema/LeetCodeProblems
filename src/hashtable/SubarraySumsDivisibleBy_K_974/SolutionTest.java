package hashtable.SubarraySumsDivisibleBy_K_974;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(7, s.subarraysDivByK(new int[] {4, 5, 0, -2, -3, 1}, 5));
    }
}