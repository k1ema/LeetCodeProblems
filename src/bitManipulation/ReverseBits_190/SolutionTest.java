package bitManipulation.ReverseBits_190;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(964176192, s.reverseBits(43261596));
        assertEquals(-1073741825, s.reverseBits(-3));
        assertEquals("10110000000000000000000000000000", Integer.toBinaryString(s.reverseBits(13)));
    }
}
