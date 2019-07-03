package stack.DecodeString_394;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void  test() {
        Solution s = new Solution();
        assertEquals("aaabcbc", s.decodeString("3[a]2[bc]"));
        assertEquals("accaccacc", s.decodeString("3[a2[c]]"));
        assertEquals("abcabccdcdcdef", s.decodeString("2[abc]3[cd]ef"));
    }
}
