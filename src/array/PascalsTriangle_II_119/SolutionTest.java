package array.PascalsTriangle_II_119;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Collections.singletonList(1), s.getRow(0));
        assertEquals(Arrays.asList(1, 1), s.getRow(1));
        assertEquals(Arrays.asList(1, 3, 3, 1), s.getRow(3));
        assertEquals(Arrays.asList(1, 4, 6, 4, 1), s.getRow(4));
        assertEquals(Arrays.asList(1, 33, 528, 5456, 40920, 237336, 1107568, 4272048, 13884156, 38567100, 92561040, 193536720, 354817320, 573166440, 818809200, 1037158320, 1166803110, 1166803110, 1037158320, 818809200, 573166440, 354817320, 193536720, 92561040, 38567100, 13884156, 4272048, 1107568, 237336, 40920, 5456, 528, 33, 1),
                s.getRow(33));
    }
}