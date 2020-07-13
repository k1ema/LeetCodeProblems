package array.MissingRanges_163;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList("2", "4->49", "51->74", "76->99"),
                s.findMissingRanges(new int[] {0, 1, 3, 50, 75}, 0, 99));
        assertEquals(Collections.singletonList("1"), s.findMissingRanges(new int[] {}, 1, 1));
        assertEquals(Collections.singletonList("1->2"), s.findMissingRanges(new int[] {}, 1, 2));
        assertEquals(Collections.singletonList("-2147483647->2147483646"),
                s.findMissingRanges(new int[] {-2147483648,2147483647}, -2147483648, 2147483647));
    }
}