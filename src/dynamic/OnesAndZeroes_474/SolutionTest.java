package dynamic.OnesAndZeroes_474;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.findMaxForm(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3));
        assertEquals(2, s.findMaxForm(new String[] {"10", "0", "1"}, 1, 1));
    }
}