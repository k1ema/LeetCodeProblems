package string.RansomNote_383;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertFalse(s.canConstruct("a", "b"));
        assertFalse(s.canConstruct("aa", "ab"));
        assertTrue(s.canConstruct("aa", "aab"));
    }
}