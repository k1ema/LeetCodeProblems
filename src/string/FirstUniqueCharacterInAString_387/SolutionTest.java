package string.FirstUniqueCharacterInAString_387;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(0, s.firstUniqChar("leetcode"));
        assertEquals(2, s.firstUniqChar("loveleetcode"));
        assertEquals(-1, s.firstUniqChar("cc"));
    }
}