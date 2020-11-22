package dynamic.NumbersAtMostNGivenDigitSet_902;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(20, s.atMostNGivenDigitSet(new String[] {"1", "3", "5", "7"}, 100));
        assertEquals(29523, s.atMostNGivenDigitSet(new String[] {"1", "4", "9"}, 1000000000));
        assertEquals(1, s.atMostNGivenDigitSet(new String[] {"7"}, 8));
        assertEquals(2, s.atMostNGivenDigitSet(new String[] {"3", "4", "8"}, 4));
        assertEquals(2221640, s.atMostNGivenDigitSet(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}, 8363065));
        assertEquals(35933218, s.atMostNGivenDigitSet(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"}, 74546987));
        assertEquals(84, s.atMostNGivenDigitSet(new String[] {"1", "2", "6"}, 2563));
    }
}