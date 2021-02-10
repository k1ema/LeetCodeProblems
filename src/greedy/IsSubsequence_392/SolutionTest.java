package greedy.IsSubsequence_392;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isSubsequence("abc", "ahbgdc"));
        assertFalse(s.isSubsequence("axc", "ahbgdc"));
    }
}