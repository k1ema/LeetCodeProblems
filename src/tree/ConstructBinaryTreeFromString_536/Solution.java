package tree.ConstructBinaryTreeFromString_536;

import tree.utils.TreeNode;

/**
 * 536. Construct Binary Tree from String
 * https://leetcode.com/problems/construct-binary-tree-from-string/
 *
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 *
 * The whole input represents a binary tree. It contains an integer followed by zero, one or two
 * pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains
 * a child binary tree with the same structure.
 *
 * You always start to construct the left child node of the parent first if it exists.
 *
 * Example 1:
 * Input: s = "4(2(3)(1))(6(5))"
 * Output: [4,2,6,3,1,5]
 *
 * Example 2:
 * Input: s = "4(2(3)(1))(6(5)(7))"
 * Output: [4,2,6,3,1,5,7]
 *
 * Example 3:
 * Input: s = "-4(2(3)(1))(6(5)(7))"
 * Output: [-4,2,6,3,1,5,7]
 *
 * Constraints:
 * 0 <= s.length <= 3 * 10^4
 * s consists of digits, '(', ')', and '-' only.
 */
public class Solution {
    // tc O(n), sc O(n)
    private int idx;
    public TreeNode str2tree(String s) {
        idx = 0;
        return helper(s);
    }

    private TreeNode helper(String s) {
        if (idx >= s.length() || s.charAt(idx) == ')') {
            idx++;
            return null;
        }
        char c = s.charAt(idx);
        int val = 0, sign = 1;
        if (c == '-') {
            sign = -1;
            idx++;
        }
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            val = val * 10 + s.charAt(idx++) - '0';
        }
        val *= sign;
        TreeNode root = new TreeNode(val);
        if (idx < s.length() && s.charAt(idx) == '(') {
            idx++;
            root.left = helper(s);
            if (idx < s.length() && s.charAt(idx) == '(') {
                idx++;
                root.right = helper(s);
            }
        }
        idx++;
        return root;
    }
}
