package hashtable.LongestSubstringWithoutRepeatingCharacters_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, s.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, s.lengthOfLongestSubstring("pwwkew"));
        assertEquals(3, s.lengthOfLongestSubstring("dvdf"));
        assertEquals(3, s.lengthOfLongestSubstring("advdddd"));
        assertEquals(3, s.lengthOfLongestSubstring("ddddavd"));
        assertEquals(4, s.lengthOfLongestSubstring("ddddavf"));
        assertEquals(1, s.lengthOfLongestSubstring("a"));
        assertEquals(2, s.lengthOfLongestSubstring("ab"));
        assertEquals(3, s.lengthOfLongestSubstring("abc"));
        assertEquals(0, s.lengthOfLongestSubstring(""));
    }
}
