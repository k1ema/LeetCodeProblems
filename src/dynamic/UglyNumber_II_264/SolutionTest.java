package dynamic.UglyNumber_II_264;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(12, s.nthUglyNumber(10));
        assertEquals(15, s.nthUglyNumber(11));
        assertEquals(51200000, s.nthUglyNumber(1000));
        assertEquals(536870912, s.nthUglyNumber(1407));
    }
}