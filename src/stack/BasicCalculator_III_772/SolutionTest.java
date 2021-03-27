package stack.BasicCalculator_III_772;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(30, s.calculate("2*(5+5*2)"));
        assertEquals(2, s.calculate("1+1"));
        assertEquals(4, s.calculate("6-4/2"));
        assertEquals(21, s.calculate("2*(5+5*2)/3+(6/2+8)"));
        assertEquals(-12, s.calculate("(2+6*3+5-(3*14/7+2)*5)+3"));
        assertEquals(0, s.calculate("0"));
    }
}