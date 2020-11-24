package dynamic.HouseRobber_III_337;

import tree.utils.TreeNode;

/**
 * 337. House Robber III
 * https://leetcode.com/problems/house-robber-iii/
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area,
 * called the "root." Besides the root, each house has one and only one parent house. After a tour, the
 * smart thief realized that "all houses in this place forms a binary tree". It will automatically contact
 * the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 *
 * Example 2:
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class Solution {
    // tc O(n), sc O(n)
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    // key = child.max, value = grandchild.max
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int rob = root.val + left[1] + right[1];
        int notrob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] {rob, notrob};
    }
}
