package dynamic.WordBreak_139;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.wordBreak("leetcode", Arrays.asList("leet", "code")));
        assertTrue(s.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        assertFalse(s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        assertTrue(s.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
        assertTrue(s.wordBreak("aaaaaaaaa", Arrays.asList("aaaa", "aaa", "aa")));
        assertTrue(s.wordBreak("aaaaaa", Arrays.asList("aaaa", "aaa")));
        assertTrue(s.wordBreak("aaaaaaa", Arrays.asList("aaaaa", "aa")));
        assertTrue(s.wordBreak("aaaaaaaa", Arrays.asList("aaaaa", "aa")));
        assertFalse(s.wordBreak("aaaaaaa", Arrays.asList("aaaaa", "aaaa")));
        assertFalse(s.wordBreak("aaa", Collections.singletonList("aa")));
    }
}
