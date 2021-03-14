package segmentTree.RangeSumQuery_Mutable_307;

/**
 * 307. Range Sum Query - Mutable
 * https://leetcode.com/problems/range-sum-query-mutable/
 *
 * Given an array nums and two types of queries where you should update the value of an index
 * in the array, and retrieve the sum of a range in the array.
 *
 * Implement the NumArray class:
 *
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * void update(int index, int val) Updates the value of nums[index] to be val.
 * int sumRange(int left, int right) Returns the sum of the subarray nums[left, right]
 * (i.e., nums[left] + nums[left + 1], ..., nums[right]).
 *
 * Example 1:
 * Input
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * Output
 * [null, 9, null, 8]
 *
 * Explanation
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // return 9 = sum([1,3,5])
 * numArray.update(1, 2);   // nums = [1,2,5]
 * numArray.sumRange(0, 2); // return 8 = sum([1,2,5])
 *
 * Constraints:
 * 1 <= nums.length <= 3 * 10^4
 * -100 <= nums[i] <= 100
 * 0 <= index < nums.length
 * -100 <= val <= 100
 * 0 <= left <= right < nums.length
 * At most 3 * 10^4 calls will be made to update and sumRange.
 */
public class NumArray {
    private int[] arr;
    private int n, offset;

    // tc O(nlogn), sc O(n)
    public NumArray(int[] nums) {
        n = nums.length;
        int k = 1;
        while ((1 << k) < n) {
            k++;
        }
        n = 1 << k;

        arr = new int[2 * n - 1];
        offset = arr.length - n;
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    // tc O(logn)
    public void update(int index, int val) {
        int ind = offset + index;
        arr[ind] = val;
        while (ind > 0) {
            int parent = (ind - 1) / 2;
            arr[parent] = arr[parent * 2 + 1] + arr[parent * 2 + 2];
            ind = parent;
        }
    }

    // tc O(logn)
    public int sumRange(int left, int right) {
        return sumRange(0, 0, n - 1, left, right);
    }

    private int sumRange(int i, int l, int r, int L, int R) {
        if (l > R || r < L) return 0;
        if (l >= L && r <= R) return arr[i];
        int m = l + (r - l) / 2;
        int leftChild = sumRange(2 * i + 1, l, m, L, R);
        int rightChild = sumRange(2 * i + 2, m + 1, r, L, R);
        return leftChild + rightChild;
    }
}
