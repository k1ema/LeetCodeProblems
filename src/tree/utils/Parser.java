package tree.utils;

public class Parser {
    public static TreeNode parseData(Integer[] data) {
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
