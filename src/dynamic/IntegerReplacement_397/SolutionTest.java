package dynamic.IntegerReplacement_397;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.integerReplacement(8));
        assertEquals(4, s.integerReplacement(7));
        assertEquals(32, s.integerReplacement(Integer.MAX_VALUE));
    }
}