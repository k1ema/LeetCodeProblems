package tree.BalancedBinaryTree_110;

import java.util.stream.Stream;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 */

public class Main {
    private static final Integer[][] DATA = {
            {3, 9, 20, null, null, 15, 7}, // true
            {1, 2, 2, 3, 3, null, null, 4, 4}, // false
            {}, // true
            {1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, null, null, 5, 5} // true
    };

    public static void main(String[] args) {
        Solution s = new Solution();
        Stream.of(DATA).map(Main::parseData).map(s::isBalanced).forEach(System.out::println);
    }

    private static TreeNode parseData(Integer[] data) {
        TreeNode[] nodes = new TreeNode[data.length];
        for (int i = data.length - 1; i >= 0; i--) {
            if (data[i] == null) {
                continue;
            }
            nodes[i] = new TreeNode(data[i]);
            int leftInd = 2 * i + 1;
            int rightInd = 2 * i + 2;
            if (leftInd < data.length) {
                nodes[i].left = nodes[leftInd];
            }
            if (rightInd < data.length) {
                nodes[i].right = nodes[rightInd];
            }
        }

        return nodes.length > 0 ? nodes[0] : null;
    }
}
