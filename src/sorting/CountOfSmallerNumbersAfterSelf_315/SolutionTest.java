package sorting.CountOfSmallerNumbersAfterSelf_315;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SolutionTest {
    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(List.of(2, 1, 1, 0), s.countSmaller(new int[] {5, 2, 6, 1}));
        assertEquals(List.of(0), s.countSmaller(new int[] {-1}));
        assertEquals(List.of(0, 0), s.countSmaller(new int[] {-1, -1}));
    }
}