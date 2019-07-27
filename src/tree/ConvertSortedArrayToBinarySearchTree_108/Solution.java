package tree.ConvertSortedArrayToBinarySearchTree_108;

import tree.utils.TreeNode;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary
 * tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Solution {
    // tc O(n), sc O(n)
    TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int from, int to) {
        if (to - from == 0) {
            return null;
        }
        int middle = from + (to - from) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedArrayToBST(nums, from, middle);
        root.right = sortedArrayToBST(nums, middle + 1, to);
        return root;
    }
}
