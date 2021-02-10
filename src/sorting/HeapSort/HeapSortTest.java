package sorting.HeapSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeapSortTest {
    @Test
    public void test() {
        Integer[] num = new Integer[] {4, 7, 5, 1, 3, 10, 8, 2, 9, 6};
        HeapSort.sort(num);
        System.out.println(Arrays.toString(num));
        assertEquals(Arrays.toString(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), Arrays.toString(num));
    }
}
