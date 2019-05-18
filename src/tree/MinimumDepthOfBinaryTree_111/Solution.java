package tree.MinimumDepthOfBinaryTree_111;

/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 */
class Solution {
    int minDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode tn) {
        if (tn == null) {
            return 0;
        }
        int dl = depth(tn.left);
        int dr = depth(tn.right);
        return hasNoChildren(tn) ? 1 : dl > 0 && dr > 0 ? Math.min(dl, dr) + 1 : Math.max(dl, dr) + 1;
    }

    private boolean hasNoChildren(TreeNode tn) {
        return tn != null && tn.left == null && tn.right == null;
    }

    // https://discuss.leetcode.com/topic/8723/my-4-line-java-solution
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        int l = minDepth1(root.left);
        int r = minDepth1(root.right);
        // (l==0 || r==0) - if node has 0 or 1 child - return child depth+1;
        // !(l==0 || r==0) - node has two children, return min from them +1.
        return (l==0 || r==0) ? l+r+1 : Math.min(l,r) + 1;
    }
}
