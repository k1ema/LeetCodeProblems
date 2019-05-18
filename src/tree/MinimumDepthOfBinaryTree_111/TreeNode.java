package tree.MinimumDepthOfBinaryTree_111;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.format("%d:[%s,%s]", val, left, right);
    }
}
