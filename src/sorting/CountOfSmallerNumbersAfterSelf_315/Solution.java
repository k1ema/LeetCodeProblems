package sorting.CountOfSmallerNumbersAfterSelf_315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 315. Count of Smaller Numbers After Self
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 *
 * You are given an integer array nums and you have to return a new counts array. The counts array has the
 * property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * Example 1:
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 *
 * Example 2:
 * Input: nums = [-1]
 * Output: [0]
 *
 * Example 3:
 * Input: nums = [-1,-1]
 * Output: [0,0]
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 */
public class Solution {
    // tc O(nlogn), sc O(n), merge sort
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Pair[] arr = new Pair[nums.length];
        Integer[] smaller = new Integer[nums.length];
        Arrays.fill(smaller, 0);
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(i, nums[i]);
        }
        mergeSort(arr, smaller);
        res.addAll(Arrays.asList(smaller));
        return res;
    }

    private Pair[] mergeSort(Pair[] arr, Integer[] smaller) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        Pair[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid), smaller);
        Pair[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length), smaller);
        for (int i = 0, j = 0; i < left.length || j < right.length;) {
            if (j == right.length || i < left.length && left[i].val <= right[j].val) {
                arr[i + j] = left[i];
                smaller[left[i].index] += j;
                i++;
            } else {
                arr[i + j] = right[j];
                j++;
            }
        }
        return arr;
    }

    private static class Pair {
        int index;
        int val;
        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
        @Override
        public String toString() {
            return String.format("[%d,%d]", index, val);
        }
    }

    // tc O(n^2), could be O(nlogn) but list.add(index, val) costs O(n)
    // sc O(n)
    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                list.add(nums[i]);
            } else {
                int insertIndex = bs(list, nums[i]);
                list.add(insertIndex, nums[i]);
                res[i] = insertIndex;
            }
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    private int bs(List<Integer> list, int target) {
        int l = -1, r = list.size();
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (list.get(m) < target) {
                l = m;
            } else {
                r = m;
            }
        }
        return r;
    }
}
