package string.BackspaceStringCompare_844;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.backspaceCompare("a", "a"));
        assertTrue(s.backspaceCompare("ab#c", "ad#c"));
        assertTrue(s.backspaceCompare("ab##", "c#d#"));
        assertTrue(s.backspaceCompare("a##c", "#a#c"));
        assertFalse(s.backspaceCompare("a#c", "b"));
        assertTrue(s.backspaceCompare("a#c#abcd#g#", "abc"));
        assertTrue(s.backspaceCompare("bxj##tw", "bxo#j##tw"));
        assertFalse(s.backspaceCompare("bbbextm", "bbb#extm"));
    }
}