package tree.MaximumDepthOfBinaryTree_104;

import java.util.stream.Stream;

import tree.utils.Parser;

public class Main {
    private static final Integer[][] DATA = {
            {}, // 0
            {1}, // 1
            {3, 9, 20, null, null, 15, 7}, // 3
            {1, 2, 2, 3, 3, null, null, 4, 4}, // 4
            {1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, null, null, 5, 5} // 5
    };

    public static void main(String[] args) {
        Solution s = new Solution();
        Stream.of(DATA).map(Parser::parseData).map(s::maxDepth).forEach(System.out::println);
    }
}
