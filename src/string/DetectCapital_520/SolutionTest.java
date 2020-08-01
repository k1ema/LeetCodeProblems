package string.DetectCapital_520;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.detectCapitalUse("USA"));
        assertTrue(s.detectCapitalUse("Google"));
        assertTrue(s.detectCapitalUse("leetcode"));
        assertFalse(s.detectCapitalUse("FlaG"));
        assertFalse(s.detectCapitalUse("leetcodE"));
    }
}