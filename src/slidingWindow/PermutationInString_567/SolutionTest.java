package slidingWindow.PermutationInString_567;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.checkInclusion("abc", "eeacbff"));
        assertTrue(s.checkInclusion("ab", "eidbaooo"));
        assertFalse(s.checkInclusion("ab", "eidboooo"));
        assertTrue(s.checkInclusion("abc", "eidbaaaabcooo"));
        assertTrue(s.checkInclusion("abc", "eidbayerabcooo"));
        assertTrue(s.checkInclusion("a", "ab"));
        assertTrue(s.checkInclusion("abcdxabcde", "abcdeabcdx"));
        assertTrue(s.checkInclusion("pqzhi", "ghrqpihzybre"));
    }
}
