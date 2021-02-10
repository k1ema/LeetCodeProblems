package string.ValidPalindrome_II_680;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.validPalindrome("aba"));
        assertTrue(s.validPalindrome("ab"));
        assertTrue(s.validPalindrome("abca"));
        assertTrue(s.validPalindrome("abcbfa"));
        assertFalse(s.validPalindrome("abcbfea"));
    }
}