package bitManipulation.NumberComplement_476;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.findComplement(5));
        assertEquals(0, s.findComplement(1));
        assertEquals(1, s.findComplement(0));
        assertEquals(1, s.findComplement(0));
        assertEquals(0, s.findComplement(7));
        assertEquals(5, s.findComplement(10));
    }
}