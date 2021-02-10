package math.ConcatenationOfConsecutiveBinaryNumbers_1680;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.concatenatedBinary(1));
        assertEquals(27, s.concatenatedBinary(3));
        assertEquals(505379714, s.concatenatedBinary(12));
    }
}