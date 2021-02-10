package array.SummaryRanges_228;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList("0->2", "4->5", "7"), s.summaryRanges(new int[] {0, 1, 2, 4, 5, 7}));
        assertEquals(Arrays.asList("0", "2->4", "6", "8->9"), s.summaryRanges(new int[] {0, 2, 3, 4, 6, 8, 9}));
        assertEquals(Collections.emptyList(), s.summaryRanges(new int[] {}));
        assertEquals(Collections.singletonList("-1"), s.summaryRanges(new int[] {-1}));
        assertEquals(Collections.singletonList("0"), s.summaryRanges(new int[] {0}));
        assertEquals(Collections.singletonList("1->5"), s.summaryRanges(new int[] {1, 2, 3, 4, 5}));
        assertEquals(Arrays.asList("-2147483648->-2147483647", "2147483647"), s.summaryRanges(new int[] {-2147483648, -2147483647, 2147483647}));
    }
}