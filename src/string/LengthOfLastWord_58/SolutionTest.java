package string.LengthOfLastWord_58;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.lengthOfLastWord("Hello World"));
        assertEquals(5, s.lengthOfLastWord("Hello World "));
        assertEquals(1, s.lengthOfLastWord("Hello World   d  "));
    }
}