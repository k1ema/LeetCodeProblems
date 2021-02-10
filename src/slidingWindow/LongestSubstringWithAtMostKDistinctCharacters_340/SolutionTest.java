package slidingWindow.LongestSubstringWithAtMostKDistinctCharacters_340;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.lengthOfLongestSubstringKDistinct("eceba", 2));
        assertEquals(2, s.lengthOfLongestSubstringKDistinct("aa", 1));
    }
}