package sorting.QuickSort;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuickSelectionTest {
    @Test
    public void test() {
        QuickSelection q = new QuickSelection();
        assertEquals(5, q.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
        assertEquals(4, q.findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        assertEquals(-1, q.findKthLargest(new int[] {-1, -1}, 2));
        assertEquals(-1, q.findKthLargest(new int[] {-1}, 1));
    }
}
