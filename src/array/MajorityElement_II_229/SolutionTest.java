package array.MajorityElement_II_229;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Collections.singletonList(3), s.majorityElement(new int[] {3, 2, 3}));
        assertEquals(Arrays.asList(1, 2), s.majorityElement(new int[] {1, 1, 1, 3, 3, 2, 2, 2}));
        assertEquals(Arrays.asList(1, 2), s.majorityElement(new int[] {1, 2, 3, 1, 2, 3, 1, 2}));
        assertEquals(Collections.singletonList(1), s.majorityElement(new int[] {1, 1, 1, 3, 4, 5, 6, 7}));
    }
}