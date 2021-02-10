package backtracking.WordBreak_II_140;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList("cat sand dog", "cats and dog"),
                s.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        assertEquals(Arrays.asList("pine apple pen apple", "pine applepen apple", "pineapple pen apple"),
                s.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        assertEquals(new ArrayList<>(),
                s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        assertEquals(new ArrayList<>(),
                s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                        Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }
}
