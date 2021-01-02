package hashtable.PalindromePermutation_266;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertFalse(s.canPermutePalindrome("code"));
        assertTrue(s.canPermutePalindrome("aab"));
        assertTrue(s.canPermutePalindrome("carerac"));
    }
}