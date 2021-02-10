package dynamic.LongestCommonSubsequence_1143;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, s.longestCommonSubsequence("abc", "abc"));
        assertEquals(0, s.longestCommonSubsequence("abc", "def"));
        assertEquals(1, s.longestCommonSubsequence("abcde", "df"));
        assertEquals(1, s.longestCommonSubsequence("psnw", "vozsh"));
        assertEquals(2, s.longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"));
        assertEquals(5, s.longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr"));
        assertEquals(1, s.longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
        assertEquals(6, s.longestCommonSubsequence("papmretkborsrurgtina", "nsnupotstmnkfcfavaxgl"));
        assertEquals(13, s.longestCommonSubsequence("bmvcnwrmxcfcxabkxcvgbozmpspsbenazglyxkpibgzq",
                "bmpmlstotylonkvmhqjyxmnqzctonqtobahcrcbibgzgx"));
    }
}
