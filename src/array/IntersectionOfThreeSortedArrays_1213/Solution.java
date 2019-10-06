package array.IntersectionOfThreeSortedArrays_1213;

import java.util.ArrayList;
import java.util.List;

/**
 * 1213. Intersection of Three Sorted Arrays
 * https://leetcode.com/contest/biweekly-contest-10/problems/intersection-of-three-sorted-arrays/
 *
 * Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order,
 * return a sorted array of only the integers that appeared in all three arrays.
 *
 * Example 1:
 * Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * Output: [1,5]
 * Explanation: Only 1 and 5 appeared in the three arrays.
 *
 * Constraints:
 * 1 <= arr1.length, arr2.length, arr3.length <= 1000
 * 1 <= arr1[i], arr2[i], arr3[i] <= 2000
 */
public class Solution {
    List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr2[j] == arr1[i]) {
                    for (int k = 0; k < arr3.length; k++) {
                        if (arr3[k] == arr1[i]) {
                            res.add(arr1[i]);
                        }
                    }
                }

            }
        }

        return res;
    }
}
