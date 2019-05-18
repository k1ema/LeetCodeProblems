package tree.BalancedBinaryTree_110;

/**
 * Good description
 * https://discuss.leetcode.com/topic/7798/the-bottom-up-o-n-solution-would-be-better
 */
class Solution {
    private boolean isBalanced = true;

    boolean isBalanced(TreeNode root) {
        isBalanced = true;
        depth(root);
        return isBalanced;
    }

    private int depth(TreeNode tn) {
        if (tn == null) {
            return 0;
        }
        int dl = depth(tn.left);
        int dr = depth(tn.right);
        if (Math.abs(dl - dr) > 1) {
            isBalanced = false;
        }
        return Math.max(dl, dr) + 1;
    }
}
