package slidingWindow.FindAllAnagramsInAString_438;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(0, 6), s.findAnagrams("cbaebabacd", "abc"));
        assertEquals(Arrays.asList(0, 6), s.findAnagrams("cbaebabac", "abc"));
        assertEquals(Arrays.asList(0, 1, 2), s.findAnagrams("abab", "ab"));
        assertEquals(Collections.emptyList(), s.findAnagrams("aa", "bb"));
    }
}
