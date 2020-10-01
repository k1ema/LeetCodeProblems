package stack.EvaluateReversePolishNotation_150;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(9, s.evalRPN(new String[] {"2", "1", "+", "3", "*"}));
        assertEquals(6, s.evalRPN(new String[] {"4", "13", "5", "/", "+"}));
        assertEquals(22, s.evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        assertEquals(1, s.evalRPN(new String[] {"4", "3", "-"}));
    }
}