package sorting.SortAnArray_912;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {
    @Test
    public void qsTest() {
        test(new QuickSort());
    }

    @Test
    public void msTest() {
        test(new MergeSort());
    }

    @Test
    public void hsTest() {
        test(new HeapSort());
    }

    private void test(Sort s) {
        assertArrayEquals(new int[] {1, 2, 3, 5}, s.sortArray(new int[] {5, 2, 3, 1}));
        assertArrayEquals(new int[] {0, 0, 1, 1, 2, 5}, s.sortArray(new int[] {5, 1, 1, 2, 0, 0}));
        assertArrayEquals(new int[] {3, 5, 6, 8, 9, 10, 12, 15, 16}, s.sortArray(new int[] {10, 16, 8, 12, 15, 6, 3, 9, 5}));
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, s.sortArray(new int[] {8, 7, 6, 5, 4, 3, 2, 1}));
        assertArrayEquals(new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8}, s.sortArray(new int[] {8, 8, 7, 7, 6, 6, 5, 5, 4, 4, 3, 3, 2, 2, 1, 1}));
    }
}
