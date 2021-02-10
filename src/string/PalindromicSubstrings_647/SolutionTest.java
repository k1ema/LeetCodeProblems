package string.PalindromicSubstrings_647;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.countSubstrings("abc"));
        assertEquals(6, s.countSubstrings("aaa"));
        assertEquals(10, s.countSubstrings("abcdcba"));
        assertEquals(6, s.countSubstrings("fdsklf"));
    }
}
