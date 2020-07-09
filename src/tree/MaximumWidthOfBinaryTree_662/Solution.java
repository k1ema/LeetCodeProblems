package tree.MaximumWidthOfBinaryTree_662;

import javafx.util.Pair;
import tree.utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 662. Maximum Width of Binary Tree
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 *
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the
 * maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null
 * nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 *
 * Example 1:
 * Input:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 *
 * Example 2:
 * Input:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 *
 * Example 3:
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 *
 * Example 4:
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 *
 * Note: Answer will in the range of 32-bit signed integer.
 */
public class Solution {
    // BFS, tc O(n), sc O(n)
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        int max = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int firstIndex = q.peek().getValue(), lastIndex = firstIndex;
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = q.poll();
                TreeNode tree = pair.getKey();
                lastIndex = pair.getValue();
                if (tree.left != null) q.add(new Pair<>(tree.left, 2 * lastIndex));
                if (tree.right != null) q.add(new Pair<>(tree.right, 2 * lastIndex + 1));
            }
            max = Math.max(max, lastIndex - firstIndex + 1);
        }
        return max;
    }

    // DFS, tc O(n), sc O(n)
    private Map<Integer, Integer> map; // depth - first index
    private int maxWidth;
    public int widthOfBinaryTree1(TreeNode root) {
        if (root == null) return 0;
        map = new HashMap<>();
        maxWidth = 0;
        dfs(root, 0, 0);
        return maxWidth;
    }

    private void dfs(TreeNode tree, int depth, int index) {
        if (tree == null) return;
        if (!map.containsKey(depth)) {
            map.put(depth, index);
        }
        int firstIndex = map.get(depth);
        maxWidth = Math.max(maxWidth, index - firstIndex + 1);
        dfs(tree.left, depth + 1, 2 * index);
        dfs(tree.right, depth + 1, 2 * index + 1);
    }
}
