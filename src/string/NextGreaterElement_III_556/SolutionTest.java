package string.NextGreaterElement_III_556;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(21, s.nextGreaterElement(12));
        assertEquals(-1, s.nextGreaterElement(21));
        assertEquals(1387683624, s.nextGreaterElement(1387683462));
    }
}