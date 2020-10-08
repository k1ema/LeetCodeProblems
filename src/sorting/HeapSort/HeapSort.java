package sorting.HeapSort;

public class HeapSort {
    public static void sort(Comparable[] a) {
        int n = a.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            sink(a, i, n);
        }
        while (n > 0) {
            swap(a, 0, n--);
            sink(a, 0, n);
        }
    }

    private static void sink(Comparable[] a, int i, int n) {
        while (2 * i <= n) {
            int j = 2 * i;
            if (j < n && less(a, j, j + 1)) j++;
            if (!less(a, i, j)) break;
            swap(a, i, j);
            i = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
