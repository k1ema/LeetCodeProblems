package string.ReverseString_344;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        char[] str = new char[] {'h', 'e', 'l', 'l', 'o'};
        s.reverseString(str);
        assertArrayEquals(new char[] {'o', 'l', 'l', 'e', 'h'}, str);

        str = new char[] {'h', 'e', 'l', 'l'};
        s.reverseString(str);
        assertArrayEquals(new char[] {'l', 'l', 'e', 'h'}, str);
    }
}