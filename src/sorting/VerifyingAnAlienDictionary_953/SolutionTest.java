package sorting.VerifyingAnAlienDictionary_953;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isAlienSorted(new String[] {"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        assertFalse(s.isAlienSorted(new String[] {"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        assertFalse(s.isAlienSorted(new String[] {"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}