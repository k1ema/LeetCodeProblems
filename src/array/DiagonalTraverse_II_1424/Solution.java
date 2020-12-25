package array.DiagonalTraverse_II_1424;

import java.util.*;

/**
 * 1424. Diagonal Traverse II
 * https://leetcode.com/problems/diagonal-traverse-ii/
 *
 * Given a list of lists of integers, nums, return all elements of nums in diagonal order as shown in the below images.
 *
 * Example 1:
 * Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,4,2,7,5,3,8,6,9]
 *
 * Example 2:
 * Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
 * Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 *
 * Example 3:
 * Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
 * Output: [1,4,2,5,3,8,6,9,7,10,11]
 *
 * Example 4:
 * Input: nums = [[1,2,3,4,5,6]]
 * Output: [1,2,3,4,5,6]
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i].length <= 10^5
 * 1 <= nums[i][j] <= 10^9
 * There at most 10^5 elements in nums.
 */
public class Solution {
    // tc O(n), sc O(n)
    // In a 2D matrix, elements in the same diagonal have same sum of their indices.
    // https://leetcode.com/problems/diagonal-traverse-ii/discuss/597741/Clean-Simple-Easiest-Explanation-with-a-picture-and-code-with-comments
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                map.putIfAbsent(i + j, new LinkedList<>());
                map.get(i + j).add(0, nums.get(i).get(j));
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            res.addAll(map.get(i));
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    // TLE
    public int[] findDiagonalOrder1(List<List<Integer>> nums) {
        int count = 0;
        for (List<Integer> list : nums) {
            count += list.size();
        }

        int[] res = new int[count];
        int k = 0, i = 0, j = 0;
        int bottomJ = 0;
        int size = nums.size();
        while (k < count) {
            List<Integer> list = nums.get(i);
            if (j < list.size()) {
                res[k++] = list.get(j);
            }
            if (i > 0) {
                i--;
                j++;
            } else if (size > 1) {
                if (size > j + 1) {
                    i = j + 1;
                    j = 0;
                    bottomJ = 0;
                } else {
                    i = size - 1;
                    bottomJ++;
                    j = bottomJ;
                }
            } else {
                j++;
            }
        }

        return res;
    }
}
