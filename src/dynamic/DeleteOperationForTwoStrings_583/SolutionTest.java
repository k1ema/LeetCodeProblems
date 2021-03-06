package dynamic.DeleteOperationForTwoStrings_583;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.minDistance("apple", "aprxe"));
        assertEquals(2, s.minDistance("eat", "sea"));
        assertEquals(6, s.minDistance("asd", "zxc"));
        assertEquals(6, s.minDistance("qwerty", "aqbwcedretfy"));
    }
}
