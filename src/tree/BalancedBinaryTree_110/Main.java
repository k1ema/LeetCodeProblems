package tree.BalancedBinaryTree_110;

import java.util.stream.Stream;

import tree.utils.Parser;

public class Main {
    private static final Integer[][] DATA = {
            {3, 9, 20, null, null, 15, 7}, // true
            {1, 2, 2, 3, 3, null, null, 4, 4}, // false
            {}, // true
            {1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, null, null, 5, 5} // true
    };

    public static void main(String[] args) {
        Solution s = new Solution();
        Stream.of(DATA).map(Parser::parseData).map(s::isBalanced).forEach(System.out::println);
    }
}
