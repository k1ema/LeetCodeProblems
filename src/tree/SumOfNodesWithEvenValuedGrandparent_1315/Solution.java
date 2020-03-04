package tree.SumOfNodesWithEvenValuedGrandparent_1315;

import tree.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1315. Sum of Nodes with Even-Valued Grandparent
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 *
 * Given a binary tree, return the sum of values of nodes with even-valued grandparent.
 * (A grandparent of a node is the parent of its parent, if it exists.)
 *
 * If there are no nodes with an even-valued grandparent, return 0.
 *
 * Example 1:
 *                  6
 *                /   \
 *               7     8
 *              / \   / \
 *             2   7 1   3
 *                        \
 *                         5
 *
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 18
 * Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the
 * even-value grandparents.
 *
 * Constraints:
 * The number of nodes in the tree is between 1 and 10^4.
 * The value of nodes is between 1 and 100.
 */
public class Solution {
    // DFS, tc O(n), sc O(1)
    // 1 ms, faster than 99.42%; 43.4 MB, less than 100.00%
    // https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/discuss/477048/JavaC%2B%2BPython-1-Line-Recursive-Solution
    public int sumEvenGrandparent(TreeNode root) {
        return helper(root, 1, 1);
    }

    private int helper(TreeNode node, int p, int gp) {
        if (node == null) return 0;
        return helper(node.left, node.val, p) + helper(node.right, node.val, p) + (gp % 2 == 0 ? node.val : 0);
    }

    // DFS, tc O(n), sc O(1)
    // 1 ms, faster than 99.42%; 43 MB, less than 100.00%
    private int res;
    public int sumEvenGrandparent1(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return null;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if (root.val % 2 == 0) {
            res += left != null ? left[0] : 0;
            res += right != null ? right[0] : 0;
        }
        int childSum = left != null ? left[1] : 0;
        childSum += right != null ? right[1] : 0;
        return new int[] {childSum, root.val};
    }

    // BFS, tc O(n), sc O(1)
    // 5 ms, faster than 17.28%; 42.7 MB, less than 100.00%
    public int sumEvenGrandparent2(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            if (tree.left != null) {
                queue.add(tree.left);
                if (tree.val % 2 == 0) {
                    if (tree.left.left != null) {
                        sum += tree.left.left.val;
                    }
                    if (tree.left.right != null) {
                        sum += tree.left.right.val;
                    }
                }
            }
            if (tree.right != null) {
                queue.add(tree.right);
                if (tree.val % 2 == 0) {
                    if (tree.right.left != null) {
                        sum += tree.right.left.val;
                    }
                    if (tree.right.right != null) {
                        sum += tree.right.right.val;
                    }
                }
            }
        }
        return sum;
    }
}
