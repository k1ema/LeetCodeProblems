package stack.BasicCalculator_II_227;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(7, s.calculate("3+2*2"));
        assertEquals(-3, s.calculate("3+2*2 - 10"));
        assertEquals(1, s.calculate(" 3/2 "));
        assertEquals(5, s.calculate(" 3+5 / 2 "));
        assertEquals(-2147483647, s.calculate("0-2147483647"));
        assertEquals(-5, s.calculate("2-3-4"));
    }
}
