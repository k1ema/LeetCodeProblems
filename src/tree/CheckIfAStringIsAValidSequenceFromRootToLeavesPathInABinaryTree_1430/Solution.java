package tree.CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree_1430;

import tree.utils.TreeNode;

/**
 * 1430. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 * https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/
 *
 * Given a binary tree where each path going from the root to any leaf form a valid
 * sequence, check if a given string is a valid sequence in such binary tree.
 *
 * We get the given string from the concatenation of an array of integers arr and the
 * concatenation of all values of the nodes along a path results in a sequence in the given binary tree.
 *
 * Example 1: (see link)
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation:
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
 * Other valid sequences are:
 * 0 -> 1 -> 1 -> 0
 * 0 -> 0 -> 0
 *
 * Example 2: (see link)
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
 * Output: false
 * Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
 *
 * Example 3: (see link)
 *
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
 * Output: false
 * Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 *
 * Constraints:
 * 1 <= arr.length <= 5000
 * 0 <= arr[i] <= 9
 *
 * Each node's value is between [0 - 9].
 */
public class Solution {
    /*
        start dfs with params: root, arr, ind in array.
        in each node compare it with arr value and return false if they differ / tree is null or ind == arr.length
        otherwise move forward
    */
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null) return false;
        return dfs(root, arr, 0);
    }

    private boolean dfs(TreeNode tree, int[] arr, int ind) {
        if (tree == null || ind == arr.length || tree.val != arr[ind]) return false;
        if (tree.left == null && tree.right == null) return ind == arr.length - 1;
        return dfs(tree.left, arr, ind + 1) || dfs(tree.right, arr, ind + 1);
    }
}
