package string.OneEditDistance_161;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isOneEditDistance("ab", "acb"));
        assertFalse(s.isOneEditDistance("", ""));
        assertTrue(s.isOneEditDistance("a", ""));
        assertTrue(s.isOneEditDistance("", "A"));
        assertFalse(s.isOneEditDistance("ab", "acd"));
        assertFalse(s.isOneEditDistance("ab", "ba"));
        assertFalse(s.isOneEditDistance("cab", "ad"));
        assertTrue(s.isOneEditDistance("a", "ac"));
    }
}