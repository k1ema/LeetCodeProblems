package binarySearch.CreateSortedArrayThroughInstructions_1649;

import java.util.ArrayList;
import java.util.List;

/**
 * 1649. Create Sorted Array through Instructions
 * https://leetcode.com/problems/create-sorted-array-through-instructions/
 *
 * Given an integer array instructions, you are asked to create a sorted array from the elements in instructions.
 * You start with an empty container nums. For each element from left to right in instructions, insert it into nums.
 * The cost of each insertion is the minimum of the following:
 *
 * The number of elements currently in nums that are strictly less than instructions[i].
 * The number of elements currently in nums that are strictly greater than instructions[i].
 * For example, if inserting element 3 into nums = [1,2,3,5], the cost of insertion is min(2, 1) (elements 1 and 2
 * are less than 3, element 5 is greater than 3) and nums will become [1,2,3,3,5].
 *
 * Return the total cost to insert all elements from instructions into nums. Since the answer may be large, return it modulo 109 + 7
 *
 * Example 1:
 * Input: instructions = [1,5,6,2]
 * Output: 1
 * Explanation: Begin with nums = [].
 * Insert 1 with cost min(0, 0) = 0, now nums = [1].
 * Insert 5 with cost min(1, 0) = 0, now nums = [1,5].
 * Insert 6 with cost min(2, 0) = 0, now nums = [1,5,6].
 * Insert 2 with cost min(1, 2) = 1, now nums = [1,2,5,6].
 * The total cost is 0 + 0 + 0 + 1 = 1.
 *
 * Example 2:
 * Input: instructions = [1,2,3,6,5,4]
 * Output: 3
 * Explanation: Begin with nums = [].
 * Insert 1 with cost min(0, 0) = 0, now nums = [1].
 * Insert 2 with cost min(1, 0) = 0, now nums = [1,2].
 * Insert 3 with cost min(2, 0) = 0, now nums = [1,2,3].
 * Insert 6 with cost min(3, 0) = 0, now nums = [1,2,3,6].
 * Insert 5 with cost min(3, 1) = 1, now nums = [1,2,3,5,6].
 * Insert 4 with cost min(3, 2) = 2, now nums = [1,2,3,4,5,6].
 * The total cost is 0 + 0 + 0 + 0 + 1 + 2 = 3.
 *
 * Example 3:
 * Input: instructions = [1,3,3,3,2,4,2,1,2]
 * Output: 4
 * Explanation: Begin with nums = [].
 * Insert 1 with cost min(0, 0) = 0, now nums = [1].
 * Insert 3 with cost min(1, 0) = 0, now nums = [1,3].
 * Insert 3 with cost min(1, 0) = 0, now nums = [1,3,3].
 * Insert 3 with cost min(1, 0) = 0, now nums = [1,3,3,3].
 * Insert 2 with cost min(1, 3) = 1, now nums = [1,2,3,3,3].
 * Insert 4 with cost min(5, 0) = 0, now nums = [1,2,3,3,3,4].
 * Insert 2 with cost min(1, 4) = 1, now nums = [1,2,2,3,3,3,4].
 * Insert 1 with cost min(0, 6) = 0, now nums = [1,1,2,2,3,3,3,4].
 * Insert 2 with cost min(2, 4) = 2, now nums = [1,1,2,2,2,3,3,3,4].
 * The total cost is 0 + 0 + 0 + 0 + 1 + 0 + 1 + 0 + 2 = 4.
 *
 * Constraints:
 * 1 <= instructions.length <= 10^5
 * 1 <= instructions[i] <= 10^5
 */
public class Solution {
    // tc O(nlogn), sc O(n)
    // Binary Indexed Tree (Fenwick Tree)
    // https://leetcode.com/problems/create-sorted-array-through-instructions/discuss/927531/JavaC%2B%2BPython-Binary-Indexed-Tree
    // 52 ms; 54.8 MB
    private int[] c;
    public int createSortedArray2(int[] instructions) {
        int res = 0, n = instructions.length, mod = (int) 1e9 + 7;
        c = new int[100001];
        for (int i = 0; i < n; i++) {
            int leftCost = get(instructions[i] - 1);
            int rightCost = i - get(instructions[i]);
            res = (res + Math.min(leftCost, rightCost)) % mod;
            update(instructions[i]);
        }
        return res;
    }

    public int get(int i) {
        int res = 0;
        while (i > 0) {
            res += c[i];
            i -= i & -i;
        }
        return res;
    }

    public void update(int i) {
        while (i < c.length) {
            c[i]++;
            i += i & -i;
        }
    }

    // segment tree solution
    // https://leetcode.com/problems/create-sorted-array-through-instructions/discuss/1010681/C%2B%2B-Solution-using-Segment-Tree-or-Simplified
    // tc O(nlogn), sc O(n)
    // 617 ms, faster than 16.50%; 55.6 MB, less than 32.67%
    public int createSortedArray(int[] instructions) {
        final int mod = (int) 1e9 + 7;
        final int MAX = (int) 1e5;
        SegmentTree st = new SegmentTree();
        int res = 0;
        for (int num : instructions) {
            int countLeft = st.getSum(0, num - 1);
            int countRight = st.getSum(num + 1, MAX);
            st.update(0, 0, MAX, num);
            res = (res + Math.min(countLeft, countRight)) % mod;
        }
        return res;
    }

    private static class SegmentTree {
        private int[] tree;
        private SegmentTree() {
            tree = new int[400000];
        }

        public int getSum(int L, int R) {
            return getSum(0, 0, (int) 1e5, L, R);
        }

        private int getSum(int i, int l, int r, int L, int R) {
            if (l > R || r < L) return 0;
            if (l >= L && r <= R) return tree[i];
            int mid = l + (r - l) / 2;
            int leftChild = getSum(2 * i + 1, l, mid, L, R);
            int rightChild = getSum(2 * i + 2, mid + 1, r, L, R);
            return leftChild + rightChild;
        }

        public void update(int index, int s, int e, int pos) {
            if (s == e) {
                tree[index]++;
                return;
            }

            int mid = s + (e - s) / 2;

            if (pos <= mid) {
                update(2 * index + 1, s, mid, pos);
            } else {
                update(2 * index + 2, mid + 1, e, pos);
            }

            tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
        }
    }

    // tc O(n * (n + logn)) = O(n^2), sc O(n)
    // 1942 ms; 120.2 MB
    public int createSortedArray1(int[] instructions) {
        final int mod = (int) 1e9 + 7;
        List<Integer> list = new ArrayList<>();
        int cost = 0;
        for (int v : instructions) {
            int l = -1, r = list.size();
            while (r - l > 1) {
                int m = (l + r) >>> 1;
                if (list.get(m) < v) {
                    l = m;
                } else {
                    r = m;
                }
            }
            int leftMostIndex = r;

            l = -1; r = list.size();
            while (r - l > 1) {
                int m = (l + r) >>> 1;
                if (list.get(m) <= v) {
                    l = m;
                } else {
                    r = m;
                }
            }
            int rightMostIndex = r;

            cost = (cost + Math.min(leftMostIndex, list.size() - rightMostIndex)) % mod;
            list.add(r, v);
        }
        return cost;
    }
}
