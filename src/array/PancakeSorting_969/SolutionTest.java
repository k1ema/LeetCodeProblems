package array.PancakeSorting_969;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Collections.emptyList(), s.pancakeSort(new int[] {}));
        assertEquals(Arrays.asList(3, 4, 2, 3, 1, 2, 1, 1), s.pancakeSort(new int[] {3, 2, 4, 1}));
    }
}