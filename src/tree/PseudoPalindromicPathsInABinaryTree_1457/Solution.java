package tree.PseudoPalindromicPathsInABinaryTree_1457;

import tree.utils.TreeNode;

/**
 * 1457. Pseudo-Palindromic Paths in a Binary Tree
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 *
 * Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said
 * to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
 *
 * Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
 *
 * Example 1:
 * Input: root = [2,3,1,3,1,null,1]
 * Output: 2
 * Explanation: The figure above represents the given binary tree. There are three paths going from
 * the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1].
 * Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3]
 * can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).
 *
 * Example 2:
 * Input: root = [2,1,1,1,3,null,null,null,null,null,1]
 * Output: 1
 * Explanation: The figure above represents the given binary tree. There are three paths going from the
 * root node to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these
 * paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).
 *
 * Example 3:
 * Input: root = [9]
 * Output: 1
 *
 * Constraints:
 * The given binary tree will have between 1 and 10^5 nodes.
 * Node values are digits from 1 to 9.
 */
public class Solution {
    // tc O(n), sc O(h), in worst case h = n
    // 2 ms, faster than 100.00%; 57.2 MB, less than 63.47%
    public int pseudoPalindromicPaths(TreeNode root) {
        return preorder(root, 0);
    }

    private int preorder(TreeNode root, int num) {
        if (root == null) return 0;
        num ^= (1 << root.val);
        int res = 0;
        if (root.left == null && root.right == null) {
            if ((num & (num - 1)) == 0) res = 1;
        } else {
            res = preorder(root.left, num) + preorder(root.right, num);
        }
        return res;
    }

    // my solution
    // tc O(n), sc O(h), in worst case h = n
    // 5 ms, faster than 82.49%; 57.2 MB, less than 63.47%
    public int pseudoPalindromicPaths1(TreeNode root) {
        return dfs(root, new int[9]);
    }

    private int dfs(TreeNode root, int[] freq) {
        if (root == null) return 0;
        freq[root.val - 1]++;
        int res = 0;
        if (root.left == null && root.right == null) {
            if (isPalindrome(freq)) res = 1;
        } else {
            res = dfs(root.left, freq) + dfs(root.right, freq);
        }
        freq[root.val - 1]--;
        return res;
    }

    private boolean isPalindrome(int[] freq) {
        int odds = 0;
        for (int v : freq) {
            if (v % 2 == 1) odds++;
            if (odds > 1) return false;
        }
        return true;
    }}
