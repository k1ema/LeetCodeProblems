package string.ValidPalindrome_III_1216;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isValidPalindrome("abcdeca", 2));
        assertTrue(s.isValidPalindrome("abcdeca", 6));
        assertTrue(s.isValidPalindrome("abcedcba", 1));
        assertTrue(s.isValidPalindrome("abdeedba", 2));
        assertTrue(s.isValidPalindrome("baacacaa", 1));
    }
}
