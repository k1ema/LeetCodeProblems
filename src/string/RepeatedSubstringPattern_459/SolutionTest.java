package string.RepeatedSubstringPattern_459;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.repeatedSubstringPattern("abab"));
        assertTrue(s.repeatedSubstringPattern("abcabcabcabc"));
        assertFalse(s.repeatedSubstringPattern("aba"));
        assertFalse(s.repeatedSubstringPattern("abac"));
        assertTrue(s.repeatedSubstringPattern("ababab"));
        assertTrue(s.repeatedSubstringPattern("aabaab"));
        assertFalse(s.repeatedSubstringPattern("aabaaba"));
        assertTrue(s.repeatedSubstringPattern("aaaa"));
    }
}