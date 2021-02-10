package greedy.StringWithout_AAA_or_BBB_984;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("aaba", s.strWithout3a3b(3, 1));
        assertEquals("aabab", s.strWithout3a3b(3, 2));
        assertEquals("aabaab", s.strWithout3a3b(4, 2));
        assertEquals("bbababababab", s.strWithout3a3b(5, 7));
        assertEquals("bbabbabbabbabbababababababababababababababababababababababab", s.strWithout3a3b(27, 33));
    }
}