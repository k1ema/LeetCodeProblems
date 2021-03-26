package string.WordSubsets_916;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(List.of("facebook", "google", "leetcode"), s.wordSubsets(new String[] {"amazon", "apple", "facebook", "google", "leetcode"}, new String[] {"e", "o"}));
        assertEquals(List.of("apple", "google", "leetcode"), s.wordSubsets(new String[] {"amazon", "apple", "facebook", "google", "leetcode"}, new String[] {"l", "e"}));
        assertEquals(List.of("facebook", "google"), s.wordSubsets(new String[] {"amazon", "apple", "facebook", "google", "leetcode"}, new String[] {"e", "oo"}));
        assertEquals(List.of("google", "leetcode"), s.wordSubsets(new String[] {"amazon", "apple", "facebook", "google", "leetcode"}, new String[] {"lo", "eo"}));
        assertEquals(List.of("facebook", "leetcode"), s.wordSubsets(new String[] {"amazon", "apple", "facebook", "google", "leetcode"}, new String[] {"ec", "oc", "ceo"}));
        assertEquals(List.of("facebook", "leetcode"), s.wordSubsets(new String[] {"amazon", "apple", "facebook", "google", "leetcode"}, new String[] {"ec", "oc", "ceo"}));
    }
}