package bitManipulation.BitwiseANDOfNumbersRange_201;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.rangeBitwiseAnd(5, 7));
        assertEquals(0, s.rangeBitwiseAnd(0, 1));
        assertEquals(12, s.rangeBitwiseAnd(12, 15));
        assertEquals(8, s.rangeBitwiseAnd(11, 15));
    }
}