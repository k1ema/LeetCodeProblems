package array.MaximumDistanceInArrays_624;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(4, s.maxDistance(Arrays.asList(
                Arrays.asList(1, 2, 3), Arrays.asList(4, 5), Arrays.asList(1, 2, 3)
        )));
        assertEquals(4, s.maxDistance(Arrays.asList(
                Arrays.asList(-3, -2, -2), Arrays.asList(-5, -4), Arrays.asList(-3, -2, -1)
        )));
        assertEquals(0, s.maxDistance(Arrays.asList(
                Collections.singletonList(-1), Collections.singletonList(-1)
        )));
        assertEquals(4, s.maxDistance(Arrays.asList(
                Arrays.asList(1, 4), Arrays.asList(0, 5)
        )));
        assertEquals(107, s.maxDistance(Arrays.asList(
                Arrays.asList(1, 10), Arrays.asList(10, 11), Arrays.asList(50, 58), Arrays.asList(100, 108)
        )));
    }
}