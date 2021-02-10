package slidingWindow.FindAllAnagramsInAString_438;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
