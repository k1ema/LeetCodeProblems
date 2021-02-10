package backtracking.PalindromePartitioning_131;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(Arrays.asList("a", "a", "b"), Arrays.asList("aa", "b")), s.partition("aab"));
        assertEquals(Arrays.asList(Arrays.asList("a", "b", "b", "a", "c"), Arrays.asList("a", "bb", "a", "c"),
                Arrays.asList("abba", "c")), s.partition("abbac"));
    }
}