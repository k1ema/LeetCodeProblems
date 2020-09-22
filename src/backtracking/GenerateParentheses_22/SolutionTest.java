package backtracking.GenerateParentheses_22;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"), s.generateParenthesis(3));
    }
}
