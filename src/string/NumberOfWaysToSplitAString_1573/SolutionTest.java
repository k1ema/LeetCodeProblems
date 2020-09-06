package string.NumberOfWaysToSplitAString_1573;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.numWays("10101"));
        assertEquals(4, s.numWays("101010"));
        assertEquals(0, s.numWays("1001"));
        assertEquals(3, s.numWays("0000"));
        assertEquals(12, s.numWays("100100010100110"));
    }
}