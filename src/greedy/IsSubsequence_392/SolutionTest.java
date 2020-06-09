package greedy.IsSubsequence_392;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isSubsequence("abc", "ahbgdc"));
        assertFalse(s.isSubsequence("axc", "ahbgdc"));
    }
}