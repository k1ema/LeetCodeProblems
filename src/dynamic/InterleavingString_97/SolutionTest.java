package dynamic.InterleavingString_97;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertFalse(s.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        assertFalse(s.isInterleave("aabcc", "dbbca", "aad"));
    }
}