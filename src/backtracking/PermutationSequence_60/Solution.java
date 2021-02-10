package backtracking.PermutationSequence_60;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. Permutation Sequence
 * https://leetcode.com/problems/permutation-sequence/
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 *
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class Solution {
    // https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
    // tc O(n^2), sc O(n)
    String getPermutation(int n, int k) {
        int[] factorials = new int[n + 1];
        List<Integer> numbers = new ArrayList<>();
        factorials[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorials[i] = factorials[i - 1] * i;
            numbers.add(i);
        }

        k--;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int ind = k / factorials[n - 1];
            sb.append(numbers.get(ind));
            k = k % factorials[n - 1];
            n--;
            numbers.remove(ind);
        }

        return sb.toString();
    }
}
