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
        1. run bs to find proper pattern length
        2. run Rabin-Karp:
            - compute hash for substring in S from 0 to len = mid
            - add it to HashSet
            - start iterating from 1 to S.length - len inclusive, compute in O(1) hash of new substring
                (using rolling hash) and check whether it contains in hash.
                h(i + 1) = (h(i) - s[i - 1] * 26^(len - 1)) * 26 + s[i + len - 1]
            - if so -> return current index
            - Add value to hash
            - return -1
    */

    // tc O(nlogn), sc O(n)
    // https://leetcode.com/problems/longest-duplicate-substring/discuss/292982/Java-version-with-comment

    private int a = 26;
    private long mod = (long) 1 << 32;

    public String longestDupSubstring(String S) {
        int n = S.length();

        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = S.charAt(i) - 'a';
        }

        int l = 0, r = n;
        int idx, foundIdx = -1, len = 0;
        while (r - l > 1) {
            int m = (l + r) >>> 1;
            idx = findSubstring(s, m);
            if (idx > -1) {
                l = m;
                len = m;
                foundIdx = idx;
            } else {
                r = m;
            }
        }

        return foundIdx == -1 ? "" : S.substring(foundIdx, foundIdx + len);
    }

    private int findSubstring(int[] s, int len) {
        long aL = 1;
        for (int i = 0; i < len; i++) {
            aL = aL * a % mod;
        }
        Set<Long> set = new HashSet<>();
        long h = 0;
        for (int i = 0; i < s.length - len + 1; i++) {
            if (i == 0) {
                for (int j = 0; j < len; j++) {
                    h = (h * a + s[j]) % mod;
                }
            } else {
                h = (h * a % mod + s[i + len - 1]) % mod;
                h = (h - s[i - 1] * aL % mod) % mod;
            }
            if (set.contains(h)) return i;
            else set.add(h);
        }
        return -1;
    }
}
