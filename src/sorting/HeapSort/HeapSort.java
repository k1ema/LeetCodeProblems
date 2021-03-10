package sorting.HeapSort;

public class HeapSort {
    public static void sort(Comparable[] a) {
        int n = a.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            sink(a, i, n);
        }
        while (n > 0) {
            swap(a, 0, n);
            sink(a, 0, --n);
        }
    }

    private static void sink(Comparable[] a, int i, int last) {
        while (2 * i <= last) {
            int childInd = 2 * i;
            if (childInd < last && less(a, childInd, childInd + 1)) {
                childInd++;
            }
            if (!less(a, i, childInd)) break;
            swap(a, i, childInd);
            i = childInd;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private static void swap(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
