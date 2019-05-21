package hashtable.IntersectionOfTwoArrays_349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class Solution {
    // time complexity: O(n+m), space complexity: O(n+m)
    int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            s.add(nums1[i]);
        }
        Set<Integer> r = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (s.contains(nums2[i])) {
                r.add(nums2[i]);
            }
        }
        return r.stream().mapToInt(i -> i).toArray();
    }

    // time complexity: O(n*m), space complexity: O(n+m)
    int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> r = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    r.add(nums1[i]);
                }
            }
        }
        return r.stream().mapToInt(i -> i).toArray();
    }

    // time complexity: O(n+m) in the average case and O(n*m) in worst, space complexity: O(n+m)
    int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        s1.retainAll(s2);
        return s1.stream().mapToInt(i -> i).toArray();
    }
}
