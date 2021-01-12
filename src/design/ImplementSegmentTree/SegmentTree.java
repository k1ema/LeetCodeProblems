package design.ImplementSegmentTree;

public class SegmentTree {
    private int n, offset;
    private int[] nums;

    public SegmentTree(int[] arr) {
        int k = 1, n = arr.length;
        while ((1 << k) < n) {
            k++;
        }
        n = 1 << k;
        nums = new int[2 * n - 1];
        this.offset = nums.length - n;
        this.n = n;
        System.arraycopy(arr, 0, nums, offset, arr.length);
        for (int i = 0; i < arr.length; i++) {
            update(i, arr[i]);
        }
    }

    public int getSum(int L, int R) {
        return getSum(0, 0, n - 1, L, R);
    }

    private int getSum(int i, int l, int r, int L, int R) {
        if (l > R || r < L) return 0;
        if (l >= L && r <= R) return nums[i];
        int leftChild = getSum(2 * i + 1, l, l + (r - l) / 2, L, R);
        int rightChild = getSum(2 * i + 2, l + (r - l) / 2 + 1, r, L, R);
        return leftChild + rightChild;
    }

    public void update(int i, int v) {
        int index = i + offset;
        nums[index] = v;
        while (index > 0) {
            int parent = (index - 1) / 2;
            nums[parent] = nums[2 * parent + 1] + nums[2 * parent + 2];
            index /= 2;
        }
    }
}
