package hashtable.PalindromePermutation_266;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertFalse(s.canPermutePalindrome("code"));
        assertTrue(s.canPermutePalindrome("aab"));
        assertTrue(s.canPermutePalindrome("carerac"));
    }
}