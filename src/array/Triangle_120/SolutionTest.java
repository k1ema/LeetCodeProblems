package array.Triangle_120;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(11, s.minimumTotal(Arrays.asList(
                Collections.singletonList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        )));
        assertEquals(-1, s.minimumTotal(Arrays.asList(
                Collections.singletonList(-1),
                Arrays.asList(2, 3),
                Arrays.asList(1, -1, -3)
        )));
    }
}
