package string.ValidPalindrome_125;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(s.isPalindrome("race a car"));
        assertFalse(s.isPalindrome("OP"));
    }
}
