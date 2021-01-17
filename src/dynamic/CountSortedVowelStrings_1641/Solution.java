package dynamic.CountSortedVowelStrings_1641;

/**
 * 1641. Count Sorted Vowel Strings
 * https://leetcode.com/problems/count-sorted-vowel-strings/
 *
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
 *
 * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
 *
 * Example 1:
 * Input: n = 1
 * Output: 5
 * Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
 *
 * Example 2:
 * Input: n = 2
 * Output: 15
 * Explanation: The 15 sorted strings that consist of vowels only are
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
 * Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
 *
 * Example 3:
 * Input: n = 33
 * Output: 66045
 *
 * Constraints:
 * 1 <= n <= 50
 */
public class Solution {
    // tc O(n), sc O(n)
    // 0 ms, faster than 100.00%; 35.8 MB, less than 61.62%
    public int countVowelStrings(int n) {
        return bt(n, 1, new Integer[n + 1][6]);
    }

    private int bt(int n, int start, Integer[][] memo) {
        if (memo[n][start] != null) return memo[n][start];
        if (n == 0) return 1;
        int res = 0;
        for (int i = start; i <= 5; i++) {
            res += bt(n - 1, i, memo);
        }
        memo[n][start] = res;
        return res;
    }

    // tc O(n^5), sc O(n)
    // tc explanation https://leetcode.com/problems/count-sorted-vowel-strings/solution/
    /*
        1. if we choose vowel 'a' for ith position, we have i - 1 positions left and we could choose from one of the 5 vowels:
            number of combinations with repetitions: C*(n,k) = C(n+k-1,k) = C*(5, i-1) = (5 + (i - 1) - 1)! / (5 - 1)! * (i - 1)! ~ i^4
        2. if we choose vowel 'e' for ith position, we have i - 1 positions left and we could choose from one of the 4 vowels:
            C*(n,k) = C*(4, i - 1) ~ i^3
        ...
        Finally, tc = Sum(1..n) (O(n^4) + O(n^3) + ... ~ O(N^0)) = O(n^5)
     */
    public int countVowelStrings1(int n) {
        return bt(n, 1);
    }

    private int bt(int n, int start) {
        if (n == 0) return 1;
        int res = 0;
        for (int i = start; i <= 5; i++) {
            res += bt(n - 1, i);
        }
        return res;
    }
}
