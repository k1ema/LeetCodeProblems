package slidingWindow.SequentialDigits_1291;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(123, 234), s.sequentialDigits(100, 300));
        assertEquals(Arrays.asList(1234, 2345, 3456, 4567, 5678, 6789, 12345),
                s.sequentialDigits(1000, 13000));
        assertEquals(Arrays.asList(12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678, 3456789, 12345678, 23456789, 123456789),
                s.sequentialDigits(10, 1000000000));
    }
}