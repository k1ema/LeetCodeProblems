package bitManipulation.DivideTwoIntegers_29;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.divide(10, 3));
        assertEquals(-2, s.divide(7, -3));
        assertEquals(0, s.divide(0, 1));
        assertEquals(1, s.divide(1, 1));
        assertEquals(2147483647, s.divide(-2147483648, -1));
        assertEquals(2147483647, s.divide(2147483647, 1));
        assertEquals(-2147483648, s.divide(-2147483648, 1));
    }
}