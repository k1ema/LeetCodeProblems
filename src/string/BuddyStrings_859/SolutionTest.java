package string.BuddyStrings_859;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.buddyStrings("ab", "ba"));
        assertFalse(s.buddyStrings("ab", "ab"));
        assertTrue(s.buddyStrings("aa", "aa"));
        assertTrue(s.buddyStrings("aaaaaaabc", "aaaaaaacb"));
        assertFalse(s.buddyStrings("", "aa"));
    }
}