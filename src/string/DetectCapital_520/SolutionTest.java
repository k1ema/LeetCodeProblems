package string.DetectCapital_520;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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