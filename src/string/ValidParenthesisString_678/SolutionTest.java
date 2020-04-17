package string.ValidParenthesisString_678;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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