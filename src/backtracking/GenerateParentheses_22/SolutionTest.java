package backtracking.GenerateParentheses_22;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"), s.generateParenthesis(3));
    }
}
