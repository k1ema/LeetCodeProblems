package math.AddDigits_258;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.addDigits(38));
        assertEquals(1, s.addDigits(1234));
    }
}