package string.RansomNote_383;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertFalse(s.canConstruct("a", "b"));
        assertFalse(s.canConstruct("aa", "ab"));
        assertTrue(s.canConstruct("aa", "aab"));
    }
}