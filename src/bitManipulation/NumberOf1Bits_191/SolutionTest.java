package bitManipulation.NumberOf1Bits_191;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.hammingWeight(11));
        assertEquals(1, s.hammingWeight(128));
        assertEquals(31, s.hammingWeight(-3));
    }
}
