package string.LongestCommonPrefix_14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("fl", s.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        assertEquals("", s.longestCommonPrefix(new String[] {"dog", "racecar", "car"}));
        assertEquals("", s.longestCommonPrefix(new String[] {"dog", "racecar", ""}));
        assertEquals("", s.longestCommonPrefix(new String[] {"", "", ""}));
        assertEquals("a", s.longestCommonPrefix(new String[] {"a"}));
        assertEquals("a", s.longestCommonPrefix(new String[] {"a", "a"}));
        assertEquals("", s.longestCommonPrefix(new String[] {null, "a"}));
    }
}
