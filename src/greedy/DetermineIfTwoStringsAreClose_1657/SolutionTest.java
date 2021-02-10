package greedy.DetermineIfTwoStringsAreClose_1657;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.closeStrings("abc", "bca"));
        assertFalse(s.closeStrings("a", "aa"));
        assertTrue(s.closeStrings("cabbba", "abbccc"));
        assertFalse(s.closeStrings("cabbba", "aabbss"));
        assertFalse(s.closeStrings("yyyuxuyuxxxxxxxyyyyyxxyyxxxyyyxyx", "uxuxuuuuuuxuuyuuuuuuyuuuuuuuyyuuu"));
        assertFalse(s.closeStrings("uau", "ssx"));
    }
}