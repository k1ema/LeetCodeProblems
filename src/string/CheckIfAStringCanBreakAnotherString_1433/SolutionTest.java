package string.CheckIfAStringCanBreakAnotherString_1433;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.checkIfCanBreak("abc", "xya"));
        assertFalse(s.checkIfCanBreak("abe", "acd"));
        assertTrue(s.checkIfCanBreak("leetcode", "interview"));
    }
}
