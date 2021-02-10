package slidingWindow.MinimumWindowSubstring_76;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("BANC", s.minWindow("HEADOBECODEBANC", "ABC"));
        assertEquals("a", s.minWindow("a", "a"));
        assertEquals("", s.minWindow("abcdefgh", "jkl"));
        assertEquals("ba", s.minWindow("bba", "ab"));
    }
}
