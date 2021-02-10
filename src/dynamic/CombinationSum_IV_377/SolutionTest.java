package dynamic.CombinationSum_IV_377;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(7, s.combinationSum4(new int[] {1, 2, 3}, 4));
        assertEquals(39882198, s.combinationSum4(new int[] {4, 2, 1}, 32));
    }
}