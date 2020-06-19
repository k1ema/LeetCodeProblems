package binarySearch.LongestDuplicateSubstring_1044;

import java.util.HashSet;
import java.util.Set;

/**
 * 1044. Longest Duplicate Substring
 * https://leetcode.com/problems/longest-duplicate-substring/
 *
 * Given a string S, consider all duplicated substrings: (contiguous) substrings of S
 * that occur 2 or more times. (The occurrences may overlap.)
 *
 * Return any duplicated substring that has the longest possible length.
 * (If S does not have a duplicated substring, the answer is "".)
 *
 * Example 1:
 * Input: "banana"
 * Output: "ana"
 *
 * Example 2:
 * Input: "abcd"
 * Output: ""
 *
 * Note:
 * 2 <= S.length <= 10^5
 * S consists of lowercase English letters.
 */
public class Solution {
    /*
          Rabin-Karp with polynomial rolling hash.
          Search a substring of given length that occurs at least 2 times.
          Return start position if the substring exits and -1 otherwise.
     */
    // tc O(nlogn), sc O(n)
    public String longestDupSubstring(String S) {
        int n = S.length();
        // convert string to array of integers to implement constant time slice
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = (int) S.charAt(i) - (int) 'a';
        }
        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long mod = (long) Math.pow(2, 32);

        // binary search, L = repeating string length
        int l = 1, r = n;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (search(m, a, mod, n, nums) != -1) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        int start = search(l - 1, a, mod, n, nums);
        return S.substring(start, start + l - 1);
    }

    private int search(int L, int a, long mod, int n, int[] nums) {
        // compute the hash of string S[:L]
        long h = 0;
        for (int i = 0; i < L; ++i) {
            h = (h * a + nums[i]) % mod;
        }

        // already seen hashes of strings of length L
        Set<Long> seen = new HashSet<>();
        seen.add(h);

        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i) {
            aL = (aL * a) % mod;
        }

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - nums[start - 1] * aL % mod + mod) % mod;
            h = (h + nums[start + L - 1]) % mod;
            if (seen.contains(h)) return start;
            seen.add(h);
        }

        return -1;
    }
}
