package tree.MinimumDepthOfBinaryTree_111;

import java.util.stream.Stream;

public class Main {
    private static final Integer[][] DATA = {
            {}, // 0
            {1}, // 1
            {1, 2}, // 2
            {1, 2, 2, 3}, // 2
            {3, 9, 20, null, null, 15, 7}, // 2
            {1, 2, 2, 3, 3, null, null, 4, 4}, // 2
            {1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, null, null, 5, 5}, // 3
            {1, 2, 3, 4, null, null, 5}, // 3
//            {1, 2, null, 3, null, 4, null, 5} // 5, error in parsing
    };

    public static void main(String[] args) {
        Solution s = new Solution();
        Stream.of(DATA).map(Main::parseData).map(s::minDepth).forEach(System.out::println);
    }

    @SuppressWarnings("Duplicates")
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