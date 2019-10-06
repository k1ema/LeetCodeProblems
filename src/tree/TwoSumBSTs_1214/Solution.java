package tree.TwoSumBSTs_1214;

import tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1214. Two Sum BSTs
 * https://leetcode.com/contest/biweekly-contest-10/problems/two-sum-bsts/
 *
 * Given two binary search trees, return True if and only if there is a node in the first tree
 * and a node in the second tree whose values sum up to a given integer target.
 *
 * Example 1:
 * Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
 * Output: true
 * Explanation: 2 and 3 sum up to 5.
 *
 * Example 2:
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
 * Output: false
 *
 * Constraints:
 * Each tree has at most 5000 nodes.
 * -10^9 <= target, node.val <= 10^9
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) return false;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        int size1 = list1.size();
        int size2 = list2.size();
        int[][] arr = new int[size1][size2];
        for (int i = 0; i < size1; i++) {
            int num1 = list1.get(i);
            for (int j = 0; j < size2; j++) {
                arr[i][j] = num1 + list2.get(j);
                if (arr[i][j] == target) return true;
            }
        }
        return false;
    }

    private void dfs(TreeNode root, List<Integer> values) {
        if (root == null) return;
        values.add(root.val);
        dfs(root.left, values);
        dfs(root.right, values);
    }
}
