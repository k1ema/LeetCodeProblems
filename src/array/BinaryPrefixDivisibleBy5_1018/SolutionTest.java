package array.BinaryPrefixDivisibleBy5_1018;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(true, false, false), s.prefixesDivBy5(new int[] {0, 1, 1}));
        assertEquals(Arrays.asList(false, false, false), s.prefixesDivBy5(new int[] {1, 1, 1}));
        assertEquals(Arrays.asList(true, false, false, false, true, false), s.prefixesDivBy5(new int[] {0, 1, 1, 1, 1, 1}));
        assertEquals(Arrays.asList(false, false, false, false, false), s.prefixesDivBy5(new int[] {1, 1, 1, 0, 1}));
        assertEquals(Arrays.asList(false, false, false, false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
                true, false, false, true, true, true, true, false),
                s.prefixesDivBy5(new int[] {1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1}));
        assertEquals(Arrays.asList(false, false, true, false, false, false, false, false, false, false, true, true, true, true, true,
                true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, true, false,
                false, true, false, false, true, true, true, true, true, true, true, false, false, true, false, false, false, false, true, true),
                s.prefixesDivBy5(new int[] {1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1,
                        0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0}));
    }
}
