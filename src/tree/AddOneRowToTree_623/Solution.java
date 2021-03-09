package tree.AddOneRowToTree_623;

import tree.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 623. Add One Row to Tree
 * https://leetcode.com/problems/add-one-row-to-tree/
 *
 * Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at
 * the given depth d. The root node is at depth 1.
 *
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create
 * two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree
 * should be the left subtree of the new left subtree root, its original right subtree should be the right
 * subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create
 * a tree node with value v as the new root of the whole original tree, and the original tree is the new root's
 * left subtree.
 *
 * Example 1:
 * Input:
 * A binary tree as following:
 *        4
 *      /   \
 *     2     6
 *    / \   /
 *   3   1 5
 *
 * v = 1
 * d = 2
 *
 * Output:
 *        4
 *       / \
 *      1   1
 *     /     \
 *    2       6
 *   / \     /
 *  3   1   5
 *
 * Example 2:
 * Input:
 * A binary tree as following:
 *       4
 *      /
 *     2
 *    / \
 *   3   1
 *
 * v = 1
 * d = 3
 *
 * Output:
 *       4
 *      /
 *     2
 *    / \
 *   1   1
 *  /     \
 * 3       1
 *
 * Note:
 * The given d is in range [1, maximum depth of the given tree + 1].
 * The given binary tree has at least one tree node.
 */
public class Solution {
    /*
        edge case:
            - d = 1 - create new root and add all tree to the left
        do bfs level order traversal
        on d-1 level put for each not null node
            if left != null
                put v as left node and add subtree to the left
            if right != null
                put v as right node and add subtree to the right
    */
    // tc O(n), sc O(x)=O(n) in worst case if last level will contain n/2 nodes
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode tree = new TreeNode(v);
            tree.left = root;
            return tree;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            while (size-- > 0) {
                TreeNode tree = q.poll();
                if (level == d - 1) {
                    TreeNode l = new TreeNode(v);
                    TreeNode leftSubTree = tree.left;
                    tree.left = l;
                    l.left = leftSubTree;
                    TreeNode r = new TreeNode(v);
                    TreeNode rightSubTree = tree.right;
                    tree.right = r;
                    r.right = rightSubTree;
                    q.add(l);
                    q.add(r);
                } else {
                    if (tree.left != null) q.add(tree.left);
                    if (tree.right != null) q.add(tree.right);
                }
            }
        }

        return root;
    }
}
