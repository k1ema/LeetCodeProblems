package dynamic.UniqueBinarySearchTrees_96;

import java.util.Arrays;

/**
 * 96. Unique Binary Search Trees
 * https://leetcode.com/problems/unique-binary-search-trees/
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 * Input: 3
 * Output: 5
 *
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class Solution {
    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return bt(n, memo);
    }

    private int bt(int n, int[] memo) {
        if (n == 0) return 1;
        if (memo[n] != -1) return memo[n];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += bt(i - 1, memo) * bt(n - i, memo);
        }
        memo[n] = count;
        return count;
    }


    // https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
    // https://leetcode.com/problems/unique-binary-search-trees/discuss/31707/Fantastic-Clean-Java-DP-Solution-with-Detail-Explaination
    // tc O(n^2), sc O(n)
    public int numTrees2(int n) {
        if (n == 0) return 1;
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    // time limit exceeded
    // tc O(n * (n-1)^2 * (n-2)^4 * ... * (n-n+1)^(2^(n-1)))) =
    // = O(n^(1 + 2^1 + 2^2 + ... + 2^(n-1))) = O(n^((2^(n-1)))), (?)
    // sc O(n)
    public int numTrees1(int n) {
        if (n == 0) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += numTrees1(i - 1) * numTrees1(n - i);
        }

        return count;
    }
}
