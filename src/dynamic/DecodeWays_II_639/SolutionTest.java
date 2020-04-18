package dynamic.DecodeWays_II_639;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(9, s.numDecodings("*"));
        assertEquals(18, s.numDecodings("1*")); // 11 12 13 14 16 17 18 19
        assertEquals(11, s.numDecodings("*1")); // 11(2), 21(2), 31(1), 41(1), 51(1), 61(1), 71(1), 81(1), 91(1)
        assertEquals(96, s.numDecodings("**"));
        assertEquals(999, s.numDecodings("***"));
        assertEquals(133236775, s.numDecodings("**********1111111111"));
    }
}