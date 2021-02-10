package dynamic.LongestPalindromicSubsequence_516;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.longestPalindromeSubseq("bbbab"));
        assertEquals(4, s.longestPalindromeSubseq("cbbcd"));
        assertEquals(3, s.longestPalindromeSubseq("babad"));
        assertEquals(3, s.longestPalindromeSubseq("bbbd"));
        assertEquals(3, s.longestPalindromeSubseq("abbbd"));
        assertEquals(2, s.longestPalindromeSubseq("cbbd"));
        assertEquals(1, s.longestPalindromeSubseq("a"));
        assertEquals(0, s.longestPalindromeSubseq(""));
    }
}
