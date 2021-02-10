package string.ReverseString_344;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("Reverse string test")
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