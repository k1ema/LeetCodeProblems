package math.CountPrimes_204;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.countPrimes(10));
        assertEquals(0, s.countPrimes(2));
        assertEquals(41537, s.countPrimes(499979));
    }
}
