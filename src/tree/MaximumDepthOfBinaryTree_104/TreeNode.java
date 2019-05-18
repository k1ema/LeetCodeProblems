package tree.MaximumDepthOfBinaryTree_104;

class TreeNode {
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
