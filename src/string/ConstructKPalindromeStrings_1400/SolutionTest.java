package string.ConstructKPalindromeStrings_1400;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.canConstruct("annabelle", 2));
        assertTrue(s.canConstruct("true", 4));
        assertFalse(s.canConstruct("leetcode", 3));
        assertTrue(s.canConstruct("yzyzyzyzyzyzyzy", 2));
        assertFalse(s.canConstruct("cr", 7));
        assertTrue(s.canConstruct("messi", 3));
        assertTrue(s.canConstruct("aaa", 2));
        assertTrue(s.canConstruct("qlkzenwmmnpkopu", 15));
        assertTrue(s.canConstruct("qlkzenwmmnpkopu", 14));
    }
}

