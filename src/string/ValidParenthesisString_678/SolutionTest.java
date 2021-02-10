package string.ValidParenthesisString_678;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.checkValidString("()"));
        assertTrue(s.checkValidString("(*)"));
        assertTrue(s.checkValidString("(*))"));
        assertTrue(s.checkValidString("((*))"));
        assertTrue(s.checkValidString("()*)"));
        assertTrue(s.checkValidString("()(*"));
        assertFalse(s.checkValidString("())*"));
        assertFalse(s.checkValidString("())"));
        assertTrue(s.checkValidString("(((******))"));
        assertFalse(s.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
        assertTrue(s.checkValidString("()*()(()(*()(((())()()())*))()*()(*)(((*))(())(())((*()*(()(())()*(((*(**))((())*)(((()()))(())()))"));
    }
}
//**((*