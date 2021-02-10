package backtracking.Combinations_77;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(1, 4),
                Arrays.asList(2, 3),
                Arrays.asList(2, 4),
                Arrays.asList(3, 4)
        ), s.combine(4, 2));

        assertEquals(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 4),
                Arrays.asList(1, 3, 4),
                Arrays.asList(2, 3, 4)
        ), s.combine(4, 3));

        assertEquals(Collections.singletonList(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), s.combine(7, 7));
    }
}
