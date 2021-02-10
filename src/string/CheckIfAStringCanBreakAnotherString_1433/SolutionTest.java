package string.CheckIfAStringCanBreakAnotherString_1433;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.checkIfCanBreak("abc", "xya"));
        assertFalse(s.checkIfCanBreak("abe", "acd"));
        assertTrue(s.checkIfCanBreak("leetcode", "interview"));
    }
}
